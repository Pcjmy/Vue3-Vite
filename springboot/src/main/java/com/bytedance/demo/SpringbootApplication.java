package com.bytedance.demo;

import com.bytedance.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  // @RestController 是一个组合注解，专门用来开发 Restful接口
@RequestMapping
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @GetMapping("/{msg}")  // localhost:9090/{msg}   //  localhost:9090/Pcjmy
    public User hello(@PathVariable String msg) {
        User user = new User();
        user.setUsername(msg);
        return user;
    }

}
