package com.atguigu.dao;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
//通用mapper 简化mybatis开发
@Repository
public interface UserMapper extends Mapper<User> {//简化mapper
}
