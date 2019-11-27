package com.wang.boot.pt.parttimes.main.enums;

import lombok.Getter;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:17
 *@description: 系统类别状态码
 */
@Getter
public enum SysDictTypeEnum implements ICodeEnums<Integer> {

    SYS_DICT_TYPE_USE(0,"此字典类别可以编辑"),
    SYS_DICT_TYPE_LOSE(1,"此字典类别不可以编辑"),
    ;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    SysDictTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
