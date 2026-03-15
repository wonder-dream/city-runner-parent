package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("u_user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)  // 雪花算法生成id
    private Long id;
    private String phone;              // 手机号（登录账号）
    private String password;           // 密码
    private String nickname;           // 昵称
    private String avatar;             // 头像URL

    /**
     * 用户类型（位运算）
     * 1 (01) = 普通用户
     * 2 (10) = 骑手
     * 3 (11) = 既是用户又是骑手
     */
    private Byte userType;

    private Byte status;               // 状态：0=禁用 1=正常

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
