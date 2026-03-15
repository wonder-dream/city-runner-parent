package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("o_payment")
public class Payment {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;           // 关联订单ID
    private Long userId;            // 支付用户ID

    private BigDecimal amount;      // 支付金额

    /**
     * 支付方式
     * 1=微信支付 2=支付宝 3=余额支付
     */
    private Byte paymentMethod;

    /**
     * 支付状态
     * 0=待支付 1=支付成功 2=支付失败 3=已退款
     */
    private Byte status;

    private String transactionId;   // 第三方交易流水号

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime payTime;      // 支付成功时间
}

