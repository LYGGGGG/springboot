package com.itheima;

/*
@author YG
@create 2023/1/2   20:26
*/

import com.itheima.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println(bean);
    }
}
