package com.scinew.service;

import com.scinew.entities.News;
import com.scinew.persistence.NewsDao;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

public interface NewsService {

    public News getNewsById(int id);
    public List<News> getNewsByDate(Date date);
    public List<News> getNewsBySite(String site);


}
