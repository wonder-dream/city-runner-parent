package com.vague.runner.common.constant;

public class UserType {

    /*
    * 用位运算实现多角色判断，userType = 3 时既是用户又是骑手
    * */

    // 角色身份位运算常量
    public static final byte CUSTOMER = 1;
    public static final byte RIDER = 2;

    // 判断是否是普通用户
    public static boolean isCustomer(byte userType)  {
        return (userType & CUSTOMER) > 0;
    }

    // 判断是否是骑手
    public static boolean isRider(byte userType)  {
        return (userType & RIDER) > 0;
    }
}
