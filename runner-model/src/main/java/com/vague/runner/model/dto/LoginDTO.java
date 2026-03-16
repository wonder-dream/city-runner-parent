package com.vague.runner.model.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String phone;      // 手机号（用户输入，登陆账号）
    private String password;   // 密码（用户输入）
}
