package com.atguigu;

import com.atguigu.pojo.User;
import com.atguigu.service.USerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    USerService uSerService;
    @Test
    public void findAll(){
        try {
            List<User> all = uSerService.findAll();
            System.out.println("all = " + all);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
