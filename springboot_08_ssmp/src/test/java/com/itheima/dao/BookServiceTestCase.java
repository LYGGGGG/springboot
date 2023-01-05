package com.itheima.dao;

/*
@author YG
@create 2023/1/5   0:51
*/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testServiceSave() {
        Book book = new Book();
        book.setId(15);
        book.setType("游戏");
        book.setName("英雄联盟");
        book.setDescription("LOL");
        boolean save = bookService.save(book);
        System.out.println(save);
    }

    @Test
    void testServiceDelete() {
        boolean result = bookService.delete(16);
        System.out.println(result);
    }

    @Test
    void testServiceUpdate() {
        Book book = new Book();
        book.setId(16);
        book.setType("游戏111");
        book.setName("英雄联盟111");
        book.setDescription("LOL");
        boolean save = bookService.update(book);
        System.out.println(save);
    }

    @Test
    void testServiceGetById() {
        Book book = bookService.getById(16);
        System.out.println(book);
    }

    @Test
    void testServiceGetAll() {
        List<Book> books = bookService.getAll();
        books.forEach(book -> System.out.println(book));
    }

    @Test
    void testServiceGetByPage() {
        IPage<Book> byPage = bookService.getByPage(1, 7);
        List<Book> records = byPage.getRecords();
        records.forEach(book -> System.out.println(book));
    }
}
