package com.scinew.persistence;

import com.scinew.entities.News;
import com.scinew.util.NewsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<News> getNewsBySite(String site) {
        String query = "SELECT * FROM news WHERE news_site = ?";
        List<News> news = jdbcTemplate.query(query, new NewsRowMapper(), site);
        return news;
    }
    public News getNewsById(int id) {
        String query = "SELECT * FROM news WHERE news_id = ?";
        News news = jdbcTemplate.queryForObject(query, new NewsRowMapper(), id);
        return news;
    }
    public List<News> getNewsByDate(Date date) {
        String query = "SELECT * FROM news WHERE news_date = ?";
        List<News> news = jdbcTemplate.query(query, new NewsRowMapper(), date);
        return news;
    }

}
