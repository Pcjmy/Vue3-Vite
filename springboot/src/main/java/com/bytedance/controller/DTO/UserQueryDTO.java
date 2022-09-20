package com.bytedance.controller.DTO;

import lombok.Data;

@Data
public class UserQueryDTO {
    private Integer currentPage;
    private Integer pageNum;
    private Integer pageSize;
    private String username;
    private String phone;
    private String email;
}
