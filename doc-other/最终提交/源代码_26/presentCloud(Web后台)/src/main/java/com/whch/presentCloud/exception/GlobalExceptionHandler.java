package com.whch.presentCloud.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 拦截所有异常
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class}) // 表示所有的异常都可以被拦截到
    public Object exceptionHandler(Exception e){
        BaseException baseException = new BaseException();
        if(e instanceof BaseException){
            baseException.setCode(((BaseException) e).getCode());
            baseException.setMsg(((BaseException) e).getMsg());
            return e;
        }
        return null;
    }
}
