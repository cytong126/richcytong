package com.wang.boot.pt.parttimes.partcategory.dto;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:29
 *@description:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wang.boot.pt.parttimes.main.utils.EnumUtil;
import com.wang.boot.pt.parttimes.partcategory.enums.CategoryStatusEnum;
import lombok.Data;

import java.util.Date;
@Data
public class PartCategoryDto {
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


/*
    //@JsonIgnore
    private String categoryStatusMsg;

    public String getCategoryStatusMsg() {
        return EnumUtil.getEnumsByCode(status , CategoryStatusEnum.class).getMsg();
    }
*/

}
