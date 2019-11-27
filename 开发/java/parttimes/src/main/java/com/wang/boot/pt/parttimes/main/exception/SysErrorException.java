package com.wang.boot.pt.parttimes.main.exception;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:15
 *@description: 后台管理员登录异常
 */

import com.wang.boot.pt.parttimes.main.enums.SysErrorEnum;
import lombok.Getter;

@Getter
public class SysErrorException extends RuntimeException {
    /**错误状态码.*/
    private Integer code;

    public SysErrorException(SysErrorEnum errorEnum){
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public SysErrorException(SysErrorEnum errorEnum, String msg){
        super(msg);
        this.code = errorEnum.getCode();
    }

}
