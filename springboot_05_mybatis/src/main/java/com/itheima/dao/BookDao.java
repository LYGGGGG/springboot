package com.itheima.dao;

/*
@author YG
@create 2023/1/4   11:35
*/

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //等价于引导类加@MapperScan("com.itheima.dao")
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
