package com.yupi.project.util;

public class TokenThreadUtil {
    public static final ThreadLocal<String> token = new ThreadLocal<String>();
    public static String getToken() {
        return token.get();
    }
    public static void setToken(String token) {
        TokenThreadUtil.token.set(token);
    }
    public static void removeToken() {
        token.remove();
    }
}
