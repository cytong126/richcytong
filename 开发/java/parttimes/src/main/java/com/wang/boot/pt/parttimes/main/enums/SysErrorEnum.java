package com.wang.boot.pt.parttimes.main.enums;

import lombok.Getter;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:17
 *@description: 系统错误码
 */
//范围 100--299
@Getter
public enum SysErrorEnum implements ICodeEnums<Integer> {


    UNKNOWN_ERROR(100,"未知错误"),
    PARAM_ERROR(101,"参数不正确"),
    NOT_LOGIN_ERROR(102,"未登录系统"),
    LOGIN_FAIL(103,"登录失败"),
    LOGIN_NOTFOUND(104,"用户名或密码错误"),
    LOGIN_SUCCESS(105,"登录成功"),
    LOGOUT_SUCCESS(106 , "登出成功"),
    LOGOUT_ERROR(107 , "登出失败"),


    ;


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    SysErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }




}
