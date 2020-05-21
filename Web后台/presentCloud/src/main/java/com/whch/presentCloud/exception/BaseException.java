package com.whch.presentCloud.exception;

// 本异常作为结果抛出
public class BaseException extends RuntimeException {

    private int code;

    private String msg;

    public BaseException() {
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
