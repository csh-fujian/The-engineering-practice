/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-05-23 12:19:24
 * @LastEditors: whc
 * @LastEditTime: 2020-05-23 12:29:04
 */ 
package com.whch.presentCloud.exception;


import lombok.Data;

@Data
public class MyException extends RuntimeException {

    /**
     * 自定义返回状态码
     */
    private Integer code;


    /**
     * 返回自定义的状态码和异常描述
     * @param code
     * @param message
     */
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 只返回异常信息(默认返回500)
     * @param message
     */
    public MyException(String message) {

        super(message);
    }




}
