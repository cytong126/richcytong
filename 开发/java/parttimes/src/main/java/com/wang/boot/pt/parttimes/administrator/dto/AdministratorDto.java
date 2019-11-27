package com.wang.boot.pt.parttimes.administrator.dto;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:29
 *@description: 後臺管理員Dto
 */

import com.wang.boot.pt.parttimes.main.utils.EnumUtil;
import com.wang.boot.pt.parttimes.partcategory.enums.CategoryStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class AdministratorDto {
    private Integer id;

    /** 管理员登录编码. */
    private String code;

    /** 管理员名称. */
    private String name;

    /** 管理员登录密码. */
    private String pass;

    /** 状态，0为正常1为失效. */
    private Integer status;

    /** 描述. */
    private String description;

}
