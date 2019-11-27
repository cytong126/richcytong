package com.wang.boot.pt.parttimes.main.enums;

import lombok.Getter;

/*
 *@author: Wang He
 *@time: 2019/10/23 0030 15:15
 *@description: 返回码
 */
@Getter
public enum ResultEnum implements ICodeEnums<Integer> {

    OK(0 , "成功"),
    ERROR(-1 , "失败"),
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
