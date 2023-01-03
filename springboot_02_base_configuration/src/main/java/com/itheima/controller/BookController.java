package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@author YG
@create 2023/1/2   19:48
*/
@RestController
@RequestMapping("/books")
public class BookController {

    // 读取yml数据中的单一数据
    @Value("${lession}")
    private String lession;

    @Value("${user.name1}")
    private String userName;

    @Autowired
    private Environment env;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");
        System.out.println("lession===>" + lession);
        System.out.println("userName===>" + userName);
        System.out.println("---------------------------");
        System.out.println(env.getProperty("lession"));
        return "springboot is running... port = 80";
    }


}
