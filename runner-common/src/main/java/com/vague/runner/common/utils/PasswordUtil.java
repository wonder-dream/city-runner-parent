package com.vague.runner.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 密码加密
    public static String encode(String rawPassword) {
        if (rawPassword == null || rawPassword.length() > 72) {
            throw new IllegalArgumentException("密码长度不能超过72个字符");
        }
        return encoder.encode(rawPassword);
    }

    // 密码验证
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
