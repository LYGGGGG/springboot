package com.itheima.controller.utils;

/*
@author YG
@create 2023/1/6   21:40
*/

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        e.printStackTrace();
        return new R(false, "系统错误，请稍后再试！");
    }
}
