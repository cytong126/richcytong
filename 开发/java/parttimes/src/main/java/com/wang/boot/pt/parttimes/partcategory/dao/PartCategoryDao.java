package com.wang.boot.pt.parttimes.partcategory.dao;

import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import com.wang.boot.pt.parttimes.partcategory.mapper.PartCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:20
 *@description:
 */

//@Mapper
//@Component
@Repository
public class PartCategoryDao {

    @Autowired
    private PartCategoryMapper mapper;

    public int insertByObject(PartCategoryDto dto){
        return mapper.insertByObject(dto);
    }

    public int insertByMap(Map<String,Object> map){
        return mapper.insertByMap(map);
    }
    public List<PartCategoryDto> selectByCategoryName(PartCategoryDto dto){
        return mapper.selectByCategoryName( dto);
    }
    public List<PartCategoryDto> selectByCon(PartCategoryDto dto){
        return mapper.selectByCon( dto);
    }

    public int updateByCon1(String categoryName,int categoryType ){
        return mapper.updateByCon1( categoryName, categoryType );
    }
    public int updateByCon2(PartCategoryDto dto){
        return mapper.updateByCon2( dto);
    }
    public List<PartCategoryDto> selectByCategoryType(PartCategoryDto dto){
        return mapper.selectByCategoryType(dto);
    }
    public List<PartCategoryDto> selectByCategoryType2(int categoryType){
        return mapper.selectByCategoryType2( categoryType);
    }





}
