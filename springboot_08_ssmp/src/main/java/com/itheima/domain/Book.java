package com.itheima.domain;

/*
@author YG
@create 2023/1/4   22:16
*/

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
