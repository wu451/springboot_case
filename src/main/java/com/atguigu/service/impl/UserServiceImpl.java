package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
@Service
public class UserServiceImpl implements USerService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    //1.只读
    // 2.propagation传播行为：7种
    //事务隔离级别4种
    //1未提交读 read-uncommitted 问题 数据丢失
    //2读已提交 read -committed   问题 脏读 oracle默认
    //3可重复读 repeatable-read     问题 不可重复读 mysql默认
    //4问题：幻读 不同事务中发生 有时候业务上是允许的(在线人数) 方法 复制一个查询服务器
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<User> findAll() throws FileNotFoundException {
        List<User> users = (List<User>) redisTemplate.boundValueOps("userkey").get();
        if (users == null) {
            users = userMapper.selectAll();
            System.out.println("users(数据库) = " + users);
            redisTemplate.boundValueOps("userkey").set(users);
        } else {
            System.out.println("users(huancun) = " + users);
        }
        return users;
    }
}



