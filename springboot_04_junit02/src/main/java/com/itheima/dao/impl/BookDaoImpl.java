package com.itheima.dao.impl;

/*
@author YG
@create 2023/1/3   22:43
*/

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running ...");
    }
}
