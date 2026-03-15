package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@TableName("u_address")
public class Address {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;                             // 所属用户
    private String contactName;                      // 联系人
    private String contactPhone;                     // 联系电话

    // 地址信息
    private String province;                          // 省
    private String city;                              // 市
    private String district;                          // 区
    private String street;                            // 街道
    private String detail;                            // 详细地址（门牌号）

    // 地理坐标
    private BigDecimal lng;                          // 经度
    private BigDecimal lat;                          // 纬度

    private String tag;                              // 标签：家、公司、学校

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
