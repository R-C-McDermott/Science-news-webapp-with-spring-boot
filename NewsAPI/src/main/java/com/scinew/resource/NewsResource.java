package com.scinew.resource;

import com.scinew.entities.News;
import com.scinew.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class NewsResource {

    @Autowired
    private NewsService newsService;

    @GetMapping(path="/news_id/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public News getNewsById(@PathVariable("id") int id) {
        return newsService.getNewsById(id);
    }

    @GetMapping(path="/news_date/{date}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<News> getNewsByDate(@PathVariable("date") Date date) {
        return newsService.getNewsByDate(date);
    }

    @GetMapping(path="/news_site/{site}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<News> getNewsBySite(@PathVariable("site") String site) {
        return newsService.getNewsBySite(site);
    }
}
