package com.wang.boot.pt.parttimes.main.enums;

import lombok.Getter;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:17
 *@description: 系统状态码
 */
@Getter
public enum SysDictEnum implements ICodeEnums<Integer> {

    SYS_DICT_USE(0,"本数据可以使用"),
    SYS_DICT_LOSE(1,"本数据已失效"),
    ;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    SysDictEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
