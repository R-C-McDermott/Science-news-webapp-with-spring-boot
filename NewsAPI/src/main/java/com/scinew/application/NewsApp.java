package com.scinew.application;

import com.scinew.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.scinew")
@EntityScan(basePackages = "com.scinew.entities")
@EnableJpaRepositories(basePackages = "com.scinew.persistence")
public class NewsApp {

    public static void main(String[] args) { SpringApplication.run(NewsApp.class, args); }

}