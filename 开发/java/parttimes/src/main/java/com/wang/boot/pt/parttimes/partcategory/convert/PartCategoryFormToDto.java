package com.wang.boot.pt.parttimes.partcategory.convert;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:50
 *@description: 将从前端传来的Form数据转换为与数据库交互的dto数据
 */

import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import com.wang.boot.pt.parttimes.partcategory.form.PartCategoryForm;

public class PartCategoryFormToDto {


    public static PartCategoryDto convert(PartCategoryForm form){
        PartCategoryDto dto = new PartCategoryDto();
        dto.setCategoryType(form.getType());
        dto.setStatus(form.getStatus());
        dto.setCategoryName(form.getName());
        return dto;
    }




}
