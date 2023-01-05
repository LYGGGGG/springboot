package com.itheima.controller.utils;

/*
@author YG
@create 2023/1/5   15:37
*/

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {

    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
