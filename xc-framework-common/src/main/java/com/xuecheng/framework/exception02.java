package com.xuecheng.framework;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @Author: houyong
 * @Date: 2019/3/4 14:47
 * @describe
 */
public class exception02 extends RuntimeException {
    ResultCode resultCode;

    public exception02(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
