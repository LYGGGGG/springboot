package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*
@author YG
@create 2023/1/5   13:49
*/
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

  /*  @GetMapping("/{cur}/{size}")
    public R getPage(@PathVariable int cur, @PathVariable int size) {
        IPage<Book> page = bookService.getByPage(cur, size);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (cur > page.getPages()) {
            page = bookService.getByPage((int) page.getPages(), size);
        }
        return new R(true, page);
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
