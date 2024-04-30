package com.yc.mybatis.common;

public class R<T> {
    private int code;
    private String message;
    private T data;
 
    // 构造函数
    public R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
 
    // 成功响应的快速创建方法
    public static <T> R<T> success(T data) {
        return new R<>(200, "Success", data);
    }
    public static <T> R<T> success() {
        return new R<>(200, "Success", null);
    }

    // 失败响应的快速创建方法
    public static <T> R<T> error(int code, String message) {
        return new R<>(code, message, null);
    }

    public static <T> R<T> error() {
        return new R<>(500, "Error", null);
    }

    // 省略getter和setter方法...
}