package com.vague.runner.model.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String phone;                     // 手机号（必填）
    private String password;                  // 密码（必填）
    private String nickname;                  // 昵称（必填）
}
