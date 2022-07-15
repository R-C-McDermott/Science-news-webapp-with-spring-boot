import mysql.connector
import datetime


class NewsDao:
    def __init__(self, host, user, password, db):
        self.host = host
        self.user = user
        self.password = password
        self.db = db
        self.connection = None
        self.news_object = None

    def set_news_object(self, news_object):
        self.news_object = news_object

    def connect_to_db(self):
        conn = mysql.connector.connect(
            host=self.host,
            user=self.user,
            password=self.password,
            database=self.db
        )

        self.connection = conn

    def db_init(self):
        cursor = self.connection.cursor()

        query = """
                CREATE TABLE IF NOT EXISTS news (
                news_id         int             PRIMARY KEY         NOT NULL        AUTO_INCREMENT,
                news_title      varchar(300)    NOT NULL,
                news_link       varchar(300)    NOT NULL,
                news_summary    varchar(2000),
                news_date       date            NOT NULL,
                news_site       varchar(200)    NOT NULL,
                UNIQUE (news_title)
                )
        """

        cursor.execute(query)

    def insert_news(self):
        date = datetime.datetime.today()
        cursor = self.connection.cursor()
        for news_tuple in self.parse_news_object():
            val = (news_tuple[0], news_tuple[1], news_tuple[2], date, self.news_object.website_name)
            query = f"""
                    INSERT IGNORE INTO news (news_title, news_link, news_summary, news_date, news_site)
                    VALUES
                    (%s, %s, %s, %s, %s)
            """
            cursor.execute(query, val)
            self.connection.commit()

    def parse_news_object(self):
        titles_list = list(self.news_object.get_news().keys())
        links_and_summary = list(self.news_object.get_news().values())
        links_list = [i for i, j in links_and_summary]
        summary_list = [j.strip() for i, j in links_and_summary]
        news_tuples = []
        for i, title in enumerate(titles_list):
            news_tuples.append((title, links_list[i], summary_list[i]))

        return news_tuples
