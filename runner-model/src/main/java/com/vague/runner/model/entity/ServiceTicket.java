package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("o_service_ticket")
public class ServiceTicket {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;           // 关联订单ID（可为空）
    private Long userId;            // 提交用户ID

    /**
     * 问题类型
     * 1=订单问题 2=支付问题 3=配送问题 4=账户问题 5=其他
     */
    private Byte issueType;

    private String title;           // 工单标题
    private String description;     // 问题描述
    private String images;          // 图片URL（多张用逗号分隔）
    /**
     * 工单状态
     * 0=待处理 1=处理中 2=已解决 3=已关闭
     */
    private Byte status;

    private Long handlerId;         // 处理客服ID
    private String reply;           // 客服回复

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private LocalDateTime handleTime;      // 处理时间
    private LocalDateTime closeTime;       // 关闭时间
}