package com.vague.runner.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RiderVO {
    private Long id;
    private String realName;
    private String idCard;
    private Byte status;  // 0=待审核 1=正常 2=休息中 3=已禁用
    private Integer totalOrders;
    private BigDecimal rating;
    private BigDecimal availableBalance;
}
