package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("o_order_review")
public class OrderReview {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;           // 订单ID
    private Long customerId;        // 评价用户ID
    private Long riderId;           // 被评价骑手ID

    private Byte rating;            // 评分：1-5星
    private String content;         // 评价内容
    private String tags;            // 标签：速度快、服务好（逗号分隔）
    private String images;          // 评价图片（多张用逗号分隔）

    private Boolean isAnonymous;    // 是否匿名

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}