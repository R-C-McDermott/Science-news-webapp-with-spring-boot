package com.sciapplication.entities;

import lombok.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {

    @Getter
    @Setter
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
