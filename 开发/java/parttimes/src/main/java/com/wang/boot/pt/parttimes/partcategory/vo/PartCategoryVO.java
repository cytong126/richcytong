package com.wang.boot.pt.parttimes.partcategory.vo;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 16:15
 *@description:
 */

import com.wang.boot.pt.parttimes.main.utils.EnumUtil;
import com.wang.boot.pt.parttimes.partcategory.enums.CategoryStatusEnum;
import lombok.Data;

import java.util.Date;
@Data
public class PartCategoryVO {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 状态，0为正常，1为失效. */
    private Integer status;

    /** 排序. */
    private Integer sort;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;

    //@JsonIgnore
    private String categoryStatusMsg;

    public String getCategoryStatusMsg() {
        return EnumUtil.getEnumsByCode(status , CategoryStatusEnum.class).getMsg();
    }
}
