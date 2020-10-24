package com.atguigu;

import com.atguigu.pojo.User;
import com.atguigu.dao.UserMapper;
import com.atguigu.service.USerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)//以spring方式启动
public class UserMapperTest {
//    @Autowired
    @Resource
    UserMapper userMapper;
    @Autowired
    USerService uSerService;
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        System.out.println("users = " + users);
    }

    @Test
    public void findAll(){
        try {
            List<User> users = uSerService.findAll();
            System.out.println("users = " + users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //可以抛自定义异常。
        }
    }
}
