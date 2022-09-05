package com.bytedance.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 性别
    private String sex;
    // 年龄
    private Integer age;
    // 电话
    private String phone;
    // 邮箱
    private String email;
    // 地址
    private String address;
    // 头像
    private String avatar;
}
