package com.bytedance.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;
}
