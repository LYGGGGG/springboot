package com.itheima.dao;

/*
@author YG
@create 2023/1/4   11:35
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper //等价于引导类加@MapperScan("com.itheima.dao")
public interface BookDao extends BaseMapper<Book> {

}
