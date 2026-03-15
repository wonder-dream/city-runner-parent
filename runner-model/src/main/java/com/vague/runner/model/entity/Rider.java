package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("u_rider")
public class Rider {
    @TableId  // 关联 u_user.id
    private Long id;

    private String realName;                  // 真实姓名
    private String idCard;                    // 身份证号
    private Byte status;                      // 状态：0=待审核 1=正常 2=休息中 3=已禁用

    // 位置信息 （用于附近搜单）
    private BigDecimal currentLng;            // 当前经度
    private BigDecimal currentLat;            // 当前纬度
    // 统计信息
    private Integer totalOrders;              // 累计接单数
    private BigDecimal rating;                // 评分（5分制）
    // 收入相关
    private BigDecimal totalEarnings;         // 累计收入
    private BigDecimal availableBalance;      // 可提现余额
    private BigDecimal frozenAmount;          // 冻结金额（未完成订单的钱）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
