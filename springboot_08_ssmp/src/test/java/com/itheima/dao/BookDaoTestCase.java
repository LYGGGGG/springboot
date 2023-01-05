package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
@author YG
@create 2023/1/4   22:44
*/
@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetAll() {
        List<Book> books = bookDao.selectList(null);
        books.forEach(book -> System.out.println(book));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试类型");
        book.setDescription("测试描述数据");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(15);
        book.setName("测试数据222");
        book.setType("测试类型222");
        book.setDescription("测试描述数据222");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(15);
    }

    @Test
    void testSelectByPage() {
        IPage page = new Page(1, 5);
        IPage page1 = bookDao.selectPage(page, null);
      /*  System.out.println(page1.getCurrent());
        System.out.println(page1.getPages());
        System.out.println(page1.getTotal());
        System.out.println(page1.getRecords());*/
        List<Book> list = page1.getRecords();
        list.forEach(book -> System.out.println(book));
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 10);
        List<Book> list = bookDao.selectList(wrapper);
        list.forEach(book -> System.out.println(book));
    }

    @Test
    void testGetBy2() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Book::getId, 12);
        List<Book> list = bookDao.selectList(wrapper);
        list.forEach(book -> System.out.println(book));
    }

    @Test
    void testGetBy3() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        String name = null;
        wrapper.like(name != null, Book::getName, name);
        List<Book> list = bookDao.selectList(wrapper);
        System.out.println(" ");
        list.forEach(book -> System.out.println(book));
    }

}
