package com.scinew.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewsDaoImpl implements NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
