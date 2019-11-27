package com.wang.boot.pt.parttimes.partcategory.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/*
 *@author: Wang He
 *@time: 2019/10/31 0031 11:09
 *@description:
 */
@SpringBootTest
@Slf4j
class PartCategoryMapperTest {

    @Autowired
    private PartCategoryMapper mapper;


    @Test
    void insertByObject() {
    }

    @Test
    void insertByMap() {
    }

    @Test
    void selectByCategoryName() {
    }

    @Test
    void selectByCon() {
        PartCategoryDto dto = new PartCategoryDto();
        dto.setCategoryType(5);
        List<PartCategoryDto> list = mapper.selectByCon(dto);

        System.out.println(list);
    }

    @Test
    void updateByCon1() {
    }

    @Test
    void updateByCon2() {
    }

    @Test
    void selectByCategoryType() {


    }

    @Test
    void selectByCategoryType2() {

        int type = 5;
        PageHelper.startPage(2,3);
        List<PartCategoryDto> list = mapper.selectByCategoryType2(type);
        PageInfo<PartCategoryDto> pageInfo =new PageInfo<PartCategoryDto>(list);
        System.out.println(list.get(0).getCategoryName());
        System.out.println("aaa"+"bbb2");

    }
}