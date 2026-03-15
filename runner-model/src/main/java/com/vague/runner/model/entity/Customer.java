package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("u_customer")
public class Customer {
    @TableId
    private Long id;                          // 不自动生成，使用user.id

    private String realName;                  // 真实姓名
    private Integer credit;                   // 信用积分
    private Integer totalOrders;              // 累计订单数
    private BigDecimal totalAmount;           // 累计消费金额
    private Integer vipLevel;                 // 会员等级

    private Long defaultAddressId;            // 默认地址ID（逻辑外键）

    private LocalDateTime lastOrderTime;      // 最近一次下单时间

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
