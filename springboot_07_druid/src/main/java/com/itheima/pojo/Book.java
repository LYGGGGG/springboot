package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@author YG
@create 2023/1/4   14:39
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id;
    private String type;
    private String name;
    private String description;
}
