package com.vague.runner.model.dto;

import lombok.Data;

@Data
public class RiderCertificationDTO {
    private String phone;                   // 手机号（必填）
    private String password;                // 密码（必填）
    private String realName;                // 真实姓名（必填）
    private String idCard;                  // 身份证号（必填）
    private String idCardFrontImage;        // 身份证正面照片URL（必填）
    private String idCardBackImage;         // 身份证反面照片URL（必填）
}
