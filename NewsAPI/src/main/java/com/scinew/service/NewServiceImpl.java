package com.scinew.service;

import com.scinew.entities.News;
import com.scinew.persistence.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class NewServiceImpl implements NewsService{

    @Autowired
    private NewsDao newsDao;

    @Override
    public News getNewsById(int id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public List<News> getNewsByDate(Date date) {
        return newsDao.getNewsByDate(date);
    }

    @Override
    public List<News> getNewsBySite(String site) {
        return newsDao.getNewsBySite(site);
    }
}
