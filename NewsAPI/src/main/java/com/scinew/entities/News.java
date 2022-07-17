package com.scinew.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class News {

    @Getter
    @Setter
    @Id
    private int newsId;
    @Getter
    @Setter
    private String newsTitle;
    @Getter
    @Setter
    private String newsLink;
    @Getter
    @Setter
    private String newsSummary;
    @Getter
    @Setter
    private Date newsDate;
    @Getter
    @Setter
    private String newsSite;
}
