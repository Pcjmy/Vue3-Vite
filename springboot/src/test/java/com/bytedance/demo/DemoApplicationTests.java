package com.bytedance.demo;

import com.bytedance.dao.UserDao;
import com.bytedance.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

//    @Autowired
//    UserDao userDao;

    @Test
    void contextLoads() {
//        List<User> users = new ArrayList(userDao.findAll());
        System.out.println(123);
//        System.out.println(users);
    }

}
