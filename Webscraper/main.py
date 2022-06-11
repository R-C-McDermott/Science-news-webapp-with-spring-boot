from webscraper import NewsStories
from news_dao import NewsDao
from datetime import datetime

# sets today's date required for latest news in 'Eurek Alert' url
year, month, day = datetime.today().strftime('%Y-%m-%d').split("-")


def main():
    eurekalert_news_object = NewsStories(base_url="https://www.eurekalert.org",
                                         latest_news_url=f"https://www.eurekalert.org/news-releases/" \
                                                         f"browse?view=summaries&date={month}/{day}/{year}",
                                         article_tag='article',
                                         article_class='post',
                                         title_tag='h2',
                                         title_class='post_title',
                                         summary_tag='p',
                                         summary_class='intro',
                                         embedded_title=False,
                                         link_class=None,
                                         website_name="Eurek-Alert")

    nature_news_object = NewsStories(base_url="https://www.nature.com",
                                     latest_news_url="https://www.nature.com/latest-news",
                                     article_tag='li',
                                     article_class=['u-flex-row__item u-flex-row__item--span-1',
                                                    'c-article-list__item u-flex-list__item cleared'],
                                     title_tag='h3',
                                     title_class='c-article-item__title mb10',
                                     summary_tag='p',
                                     summary_class=None,
                                     embedded_title=False,
                                     link_class=None,
                                     website_name="Nature")

    sci_org_news_object = NewsStories(base_url="https://www.science.org",
                                      latest_news_url="https://www.science.org/news/all-news",
                                      article_tag='article',
                                      article_class='card-do',
                                      title_tag='a',
                                      title_class='title',
                                      summary_tag='div',
                                      summary_class='card-body text-darker-gray',
                                      embedded_title=True,
                                      link_class='text-reset animation-underline',
                                      website_name='Science.org')

    news_objects = [eurekalert_news_object, nature_news_object, sci_org_news_object]

    # Initialise database connection
    db = NewsDao(host="localhost", user="root", password="pass", db="newsstories")
    db.connect_to_db()
    db.db_init()

    for news in news_objects:
        db.set_news_object(news)
        db.insert_news()

if __name__ == '__main__':
    main()
