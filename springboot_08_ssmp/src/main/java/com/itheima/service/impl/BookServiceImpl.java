package com.itheima.service.impl;

/*
@author YG
@create 2023/1/5   0:32
*/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        int result = bookDao.insert(book);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        int result = bookDao.deleteById(id);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Book book) {
        int result = bookDao.updateById(book);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book getById(Integer id) {
        Book book = bookDao.selectById(id);
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = bookDao.selectList(null);
        return books;
    }

    @Override
    public IPage<Book> getByPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        IPage pages = bookDao.selectPage(page, null);
        return pages;
    }
}
