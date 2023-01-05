package com.itheima.dao;

/*
@author YG
@create 2023/1/5   0:51
*/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    private IBookService iBookService;

    @Test
    void testServiceSave() {
        Book book = new Book();
        book.setId(15);
        book.setType("游戏");
        book.setName("英雄联盟");
        book.setDescription("LOL");
        boolean save = iBookService.save(book);
        System.out.println(save);
    }
    @Test
    void testServiceUpdate() {
        Book book = new Book();
        book.setId(17);
        book.setType("游戏111");
        book.setName("英雄联盟111");
        book.setDescription("LOL");
        boolean save = iBookService.updateById(book);
        System.out.println(save);
    }
    @Test
    void testServiceDelete() {
        boolean result = iBookService.removeById(17);
        System.out.println(result);
    }


    @Test
    void testServiceGetById() {
        Book book = iBookService.getById(16);
        System.out.println(book);
    }

    @Test
    void testServiceGetAll() {
        List<Book> books = iBookService.list();
        books.forEach(book -> System.out.println(book));
    }

    @Test
    void testServiceGetByPage() {
//        IPage<Book> byPage = iBookService.getByPage(1,7);
        Page<Book> page = iBookService.page(new Page<Book>(1, 7));
        List<Book> records = page.getRecords();
        records.forEach(book -> System.out.println(book));
    }
}
