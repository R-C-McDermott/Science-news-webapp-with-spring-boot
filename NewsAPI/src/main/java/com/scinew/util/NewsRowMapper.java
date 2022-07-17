package com.scinew.util;

import com.scinew.entities.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsRowMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("news_id");
        String newsTitle = resultSet.getString("news_title");
        String newsLink = resultSet.getString("news_link");
        String newsSummary = resultSet.getString("news_summary");
        Date newsDate = resultSet.getDate("news_date");
        String newsSite = resultSet.getString("news_site");

        return new News(id, newsTitle, newsLink, newsSummary, newsDate, newsSite);
    }
}
