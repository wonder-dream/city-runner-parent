package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@TableName("s_fee_config")
public class FeeConfig {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String city;                // 城市

    private BigDecimal baseFee;         // 起步价
    private BigDecimal baseDistance;    // 起步距离（公里）
    private BigDecimal pricePerKm;      // 每公里价格

    private BigDecimal baseWeight;      // 免费重量
    private BigDecimal weightFee;       // 重量费（每kg）

    private LocalTime nightStartTime;   // 夜间开始时间（如 22:00:00）
    private LocalTime nightEndTime;     // 夜间结束时间（如 06:00:00）
    private BigDecimal nightMarkup;     // 夜间加价

    private Byte status;                // 状态：0=禁用 1=启用

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}