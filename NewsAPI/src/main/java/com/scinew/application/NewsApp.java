package com.scinew.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.scinews")
@EntityScan(basePackages = "com.scinews.entities")
public class NewsApp {

    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
    }

}