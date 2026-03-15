package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("o_order_status_log")
public class OrderStatusLog {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;           // 订单ID

    private Byte oldStatus;         // 变更前状态
    private Byte newStatus;         // 变更后状态

    private Long operatorId;        // 操作人ID（用户或骑手）
    private Byte operatorType;      // 操作人类型：1=用户 2=骑手 3=系统

    private String remark;          // 备注（如取消原因）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;  // 变更时间
}
