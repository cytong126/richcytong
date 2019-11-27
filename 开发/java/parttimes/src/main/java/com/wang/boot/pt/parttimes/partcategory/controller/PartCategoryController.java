package com.wang.boot.pt.parttimes.partcategory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.boot.pt.parttimes.main.utils.ResultUtil;
import com.wang.boot.pt.parttimes.main.vo.ResultVO;
import com.wang.boot.pt.parttimes.partcategory.convert.PartCategoryDtoToVO;
import com.wang.boot.pt.parttimes.partcategory.convert.PartCategoryFormToDto;
import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import com.wang.boot.pt.parttimes.partcategory.form.PartCategoryForm;
import com.wang.boot.pt.parttimes.partcategory.service.PartCategoryService;
import com.wang.boot.pt.parttimes.partcategory.vo.PartCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:32
 *@description:
 */
@RestController
@RequestMapping("/PartCategory")
@Slf4j
public class PartCategoryController {

    @Autowired
    private PartCategoryService service;

    @GetMapping(value = "selectByCategoryType2")
    public ResultVO<List<PartCategoryDto>> selectByCategoryType2(){
        int type = 5;
        List<PartCategoryDto> list = service.selectByCategoryType2(type);
        return ResultUtil.success(list);
    }

    @PostMapping(value = "selectByCon")
    public ResultVO<List<PartCategoryDto>> selectByCon(PartCategoryForm form){
        PartCategoryDto dto = PartCategoryFormToDto.convert(form);
        List<PartCategoryDto> list = service.selectByCon(dto);
        List<PartCategoryVO> voList = PartCategoryDtoToVO.convert(list);
        return ResultUtil.success(voList);
    }

    @PostMapping(value = "selectByConByPage")
    public ResultVO<List<PartCategoryDto>> selectByConByPage(PartCategoryForm form){
        PartCategoryDto dto = PartCategoryFormToDto.convert(form);
        PageHelper.startPage(2,3);
        List<PartCategoryDto> list = service.selectByCon(dto);
        List<PartCategoryVO> voList = PartCategoryDtoToVO.convert(list);
        PageInfo<PartCategoryVO> pageInfo =new PageInfo<PartCategoryVO>(voList);
        return ResultUtil.success(pageInfo);
    }



}
