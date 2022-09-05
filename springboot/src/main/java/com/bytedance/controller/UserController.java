package com.bytedance.controller;

import com.bytedance.common.Result;
import com.bytedance.dao.UserDao;
import com.bytedance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    //    @PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {  // @RequestBody接受一个json参数
        if (user.getUsername() == null || user.getPassword() == null) {
            return Result.error("参数错误");
        }
        User result = userDao.getByUser(user.getUsername(), user.getPassword());
        if (result == null) {
            return Result.error("用户名或密码错误");
        }
        return Result.success(result);
    }

    @GetMapping   // localhost:9090/  //  localhost:9090/Pcjmy
    public Result findAll() {
        return Result.success(userDao.findAll());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return Result.success(userDao.getById(id));
    }

    @GetMapping("/uniqueQuery")
    public Result uniqueQuery(String username, String password) {
        return Result.success(userDao.getByUser(username, password));
    }

    @PostMapping
    public Result save(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return Result.error("参数错误");
        }
        return Result.success(userDao.insert(user));  // 返回数据库操作的记录数，大于0的时候，则表示操作成功，反之无操作
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        if (user.getId() == null) {
            return Result.error("参数错误");
        }
        return Result.success(userDao.update(user));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (id == null || id == 0) {
            return Result.error("参数错误");
        }
        return Result.success(userDao.deleteById(id) == 1);
    }
}
