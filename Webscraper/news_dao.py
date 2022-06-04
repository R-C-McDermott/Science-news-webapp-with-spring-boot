import MySQLdb # switch to sqlite3
import datetime


class NewsDao:
    def __init__(self, host, user, password, port, db, news_object):
        self.host = host
        self.user = user
        self.password = password
        self.port = port
        self.db = db
        self.news_object = news_object
        self.connection = None

    def connect_to_db(self):
        conn = MySQLdb.Connection(
            host=self.host,
            user=self.user,
            passwd=self.password,
            port=self.port,
            db=self.db
        )

        self.connection = conn

    def insert_news(self):
        date = datetime.today()
        for titles, links, summaries in self.parse_news_object():
            pass

    def parse_news_object(self):
        titles_list = list(self.news_object.get_news().keys())
        links_and_summary = list(self.news_object.get_news().values())
        links_list = [i for i, j in links_and_summary]
        summary_list = [j.strip() for i, j in links_and_summary]

        return titles_list, links_list, summary_list