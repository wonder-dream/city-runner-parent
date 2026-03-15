package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("u_service_staff")
public class ServiceStaff {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String staffName;       // 登录账号
    private String password;        // 登录密码
    private String realName;        // 真实姓名
    private String phone;           // 联系电话

    /**
     * 状态
     * 0=离线 1=在线 2=忙碌 3=已禁用
     */
    private Byte status;

    private Integer totalHandled;   // 累计处理工单数

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
