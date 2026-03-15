package com.vague.runner.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("o_withdraw_record")
public class WithdrawRecord {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long riderId;               // 骑手ID
    private BigDecimal amount;          // 提现金额

    /**
     * 提现方式
     * 1=支付宝 2=微信 3=银行卡
     */
    private Byte withdrawMethod;

    private String accountInfo;         // 账户信息（支付宝账号/微信号/银行卡号）

    /**
     * 提现状态
     * 0=待审核 1=审核通过 2=已打款 3=已拒绝
     */
    private Byte status;

    private String remark;              // 备注（拒绝原因等）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private LocalDateTime auditTime;    // 审核时间
    private LocalDateTime payTime;      // 打款时间
}