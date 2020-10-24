package com.atguigu.service;

import com.atguigu.pojo.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface USerService {
    public List<User> findAll() throws FileNotFoundException;
}
