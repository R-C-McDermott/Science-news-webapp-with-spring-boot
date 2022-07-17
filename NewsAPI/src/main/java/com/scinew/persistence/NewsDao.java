package com.scinew.persistence;

import com.scinew.entities.News;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public interface NewsDao {
    public List<News> getNewsBySite(String site);
    public News getNewsById(int id);
    public List<News> getNewsByDate(Date date);

}
