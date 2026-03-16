package com.vague.runner.common.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    // 通用状态码
    SUCCESS(200, "操作成功"),
    ERROR(500, "系统异常"),

    // 参数校验 400x
    PARAM_ERROR(4001, "参数错误"),
    PHONE_FORMAT_ERROR(4002, "手机号格式错误"),

    // 认证授权 401x
    UNAUTHORIZED(4011, "未登录"),
    TOKEN_EXPIRED(4012, "登录已过期"),

    // 用户相关 100x
    USER_NOT_FOUND(1001, "用户不存在"),
    PASSWORD_ERROR(1002, "密码错误"),
    PHONE_EXISTS(1003, "手机号已注册"),
    USER_DISABLED(1004, "账号已被禁用"),

    // 订单相关 200x
    ORDER_NOT_FOUND(2001, "订单不存在"),
    ORDER_STATUS_ERROR(2002, "订单状态异常"),
    ORDER_CANNOT_CANCEL(2003, "订单无法取消"),
    ORDER_ALREADY_ACCEPTED(2004, "订单已被接单"),

    // 骑手相关 300x
    RIDER_NOT_FOUND(3001, "骑手不存在"),
    RIDER_STATUS_ERROR(3002, "骑手状态异常"),
    RIDER_NOT_AVAILABLE(3003, "骑手不在服务状态"),

    // 支付相关 500x
    PAYMENT_FAILED(5001, "支付失败"),
    BALANCE_NOT_ENOUGH(5002, "余额不足");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
