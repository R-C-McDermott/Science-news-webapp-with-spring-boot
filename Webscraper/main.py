from webscraper import NewsStories
import news_dao
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
                                         link_class=None)

    # title_list, links_list and summary_list prepared to add to DB





if __name__ == '__main__':
    main()
