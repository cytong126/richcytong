package com.wang.boot.pt.parttimes.partcategory.form;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 16:17
 *@description:
 */

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class PartCategoryForm {

   // @NotEmpty(message = "类型不能为空")
    private Integer type;
   // @NotEmpty(message = "状态不能为空")
    private Integer status;

    private String name;


}
