package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.USerService;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController

public class UserController {
    @Autowired
    USerService uSerService;
    @RequestMapping("/user/findAll")
    @ResponseBody
    public Result findAll() {
        try {
            List<User> all = uSerService.findAll();
            return Result.ok(all);
        } catch (FileNotFoundException e) {
            return Result.error("失败");
        }
    }

}
