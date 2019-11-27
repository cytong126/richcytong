package com.wang.boot.pt.parttimes.partcategory.service;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:24
 *@description:
 */

import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;

import java.util.List;

public interface PartCategoryService {
    public int insertByObject(PartCategoryDto dto);
    public List<PartCategoryDto> selectByCategoryType(PartCategoryDto dto);
    public List<PartCategoryDto> selectByCategoryType2(int categoryType);
    public List<PartCategoryDto> selectByCon(PartCategoryDto dto);
}
