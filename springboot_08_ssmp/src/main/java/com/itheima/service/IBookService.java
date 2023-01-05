package com.itheima.service;

/*
@author YG
@create 2023/1/5   1:15
*/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IBookService extends IService<Book> {

    List<Book> getAll();

    IPage<Book> getByPage(int current, int size);
}
