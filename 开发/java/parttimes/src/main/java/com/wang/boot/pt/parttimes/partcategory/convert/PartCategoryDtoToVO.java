package com.wang.boot.pt.parttimes.partcategory.convert;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:50
 *@description: 将从数据库中查到的数据转换为与前端相接的VO数据
 */

import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import com.wang.boot.pt.parttimes.partcategory.vo.PartCategoryVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PartCategoryDtoToVO {

    public static PartCategoryVO convert(PartCategoryDto dto) {
        PartCategoryVO vo = new PartCategoryVO();
       // BeanUtils.copyProperties(orderMaster , orderDTO);
        BeanUtils.copyProperties(dto,vo);
        System.out.println(vo.getCategoryName());
        return vo;
    }



    public static List<PartCategoryVO> convert(List<PartCategoryDto> dto) {
        return dto.stream().map(e -> convert(e))
                .collect(Collectors.toList());
    }



}
