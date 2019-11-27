package com.wang.boot.pt.parttimes.partcategory.service.impl;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:26
 *@description:
 */

import com.wang.boot.pt.parttimes.partcategory.dao.PartCategoryDao;
import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import com.wang.boot.pt.parttimes.partcategory.service.PartCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PartCategoryServiceImpl implements PartCategoryService {

    @Autowired
    private PartCategoryDao dao;



    @Override
    @Transactional
    public int insertByObject(PartCategoryDto dto) {
        return dao.insertByObject(dto);
    }

    @Override
    public List<PartCategoryDto> selectByCategoryType(PartCategoryDto dto) {
        return dao.selectByCategoryType(dto);
    }

    @Override
    public List<PartCategoryDto> selectByCategoryType2(int categoryType) {
        return dao.selectByCategoryType2(categoryType);
    }
    @Override
    public List<PartCategoryDto> selectByCon(PartCategoryDto dto){
        return dao.selectByCon(dto);
    }


}
