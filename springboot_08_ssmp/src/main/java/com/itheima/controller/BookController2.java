package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@author YG
@create 2023/1/5   13:49
*/
//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }
/*
    @GetMapping("/{cur}/{size}")
    public IPage<Book> getPage(@PathVariable int cur, @PathVariable int size) {
        return bookService.getByPage(cur, size, book);
    }*/

    @GetMapping("/{cur}/{size}")
    public R getPage(@PathVariable int cur, @PathVariable int size, Book book) {
        IPage<Book> page = bookService.getByPage(cur, size, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (cur > page.getPages()) {
            page = bookService.getByPage((int) page.getPages(), size, book);
        }
        return new R(true, page);
    }
}
