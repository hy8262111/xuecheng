package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: houyong
 * @Date: 2019/3/4 0:09
 * @describe
 */
@RestControllerAdvice
public class ExceptionCatch {

    //不可预知的异常分为两种，1.我们知道所不可预知的异常是什么，我们用一个map来对应， 2.不可预知的，抛出99999异常
    //ImmutableMap是不可变的，线程安全的
    private ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;

    //用于构建ImmutableMap，往里面添加映射
    private static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    static {
        builder.put(org.springframework.http.converter.HttpMessageNotReadableException.class, CommonCode.INVIDATE);
    }

//    //捕获不可预知的异常
//    @ExceptionHandler
//    public ResponseResult catchException(Exception e) {
//        if (EXCEPTIONS == null) {
//            EXCEPTIONS = builder.build();
//        }
//        ResultCode resultCode = EXCEPTIONS.get(e.getClass());
//        if (resultCode != null) {
//            return new ResponseResult(resultCode);
//        }
//        return new ResponseResult(CommonCode.SERVER_ERROR);
//    }


    //程序员可预知的异常
    @ExceptionHandler
    public ResponseResult customException(CustomException c) {
        ResultCode resultCode = c.getResultCode();
        return new ResponseResult(resultCode);
    }


}
