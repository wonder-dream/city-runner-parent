package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("o_order")
public class Order {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    // 用户信息
    private Long customerId;     // 下单用户id
    private Long riderId;        // 接单骑手id

    // 取货地址快照（冗余存储）
    private String pickupAddress;       // 取货完整地址
    private BigDecimal pickupLng;       // 取货经度
    private BigDecimal pickupLat;       // 取货纬度
    private String pickupContact;       // 取货联系人
    private String pickupPhone;         // 取货联系电话

    // 送货地址快照
    private String deliveryAddress;        // 送货完整地址
    private BigDecimal deliveryLng;        // 送货经度
    private BigDecimal deliveryLat;        // 送货纬度
    private String deliveryContact;        // 送货联系人
    private String deliveryPhone;          // 送货联系电话

    // 订单信息
    private String goodsDesc;       // 物品描述
    private BigDecimal weight;      // 重量（kg）
    private BigDecimal distance;    // 距离（公里）

    // 费用
    private BigDecimal totalFee;    // 总费用

    /**
     * 订单状态
     * 0=待支付 1=待接单 2=取货中 3=配送中 4=已完成 5=已取消
     */
    private Byte status;

    // 时间节点
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;       // 下单时间
    private LocalDateTime payTime;          // 支付时间
    private LocalDateTime acceptTime;       // 接单时间
    private LocalDateTime pickupTime;       // 取货时间
    private LocalDateTime deliveryTime;     // 送达时间
    private LocalDateTime cancelTime;       // 取消时间
}
