package com.wang.boot.pt.parttimes.partcategory.enums;

import com.wang.boot.pt.parttimes.main.enums.ICodeEnums;
import lombok.Getter;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:17
 *@description: 系统状态码
 */
@Getter
public enum CategoryStatusEnum implements ICodeEnums<Integer> {

    CATEGORY_STATUS_USE(0,"正常"),
    CATEGORY_STATUS_LOSE(1,"失效"),
    ;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    CategoryStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
