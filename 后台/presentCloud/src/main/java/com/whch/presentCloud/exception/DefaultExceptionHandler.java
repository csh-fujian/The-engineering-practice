
/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-05-23 12:19:24
 * @LastEditors: whc
 * @LastEditTime: 2020-06-23 12:49:58
 */
package com.whch.presentCloud.exception;

import lombok.extern.slf4j.Slf4j;

import com.whch.presentCloud.entity.ResponseData;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@ControllerAdvice  //不指定包默认加了@Controller和@RestController都能控制
//@ControllerAdvice(basePackages ="com.example.demo.controller")

public class DefaultExceptionHandler {




    /**
     * 异常统一自定义处理
     */
    @ExceptionHandler({MyException.class})
    @ResponseBody
    public ResponseData MyException(MyException e) {
        ResponseData responseData=new ResponseData<>();
        responseData.setCode(500);
        responseData.setMsg(e.getMessage());
        responseData.setData(null);
        return responseData;
    }
    /**
     * 异常统一处理(最后的异常处理)
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseData allException(Exception e) {
        ResponseData responseData=new ResponseData<>();
        responseData.setCode(500);
        responseData.setMsg("系统异常");
        responseData.setData(null);
        return responseData;
    }


}
