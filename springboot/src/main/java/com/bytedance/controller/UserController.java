package com.bytedance.controller;

import com.bytedance.dao.UserDao;
import com.bytedance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping   // localhost:9090/  //  localhost:9090/Pcjmy
    public List<User> findAll() {
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userDao.getById(id);
    }

    @GetMapping("/uniqueQuery")
    public User uniqueQuery(String username, String password) {
        return userDao.getByUser(username, password);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new RuntimeException("参数错误");
        }
        userDao.insert(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        if (user.getId() == null) {
            throw new RuntimeException("参数错误");
        }
        userDao.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("参数错误");
        }
        return userDao.deleteById(id) == 1;
    }

}
