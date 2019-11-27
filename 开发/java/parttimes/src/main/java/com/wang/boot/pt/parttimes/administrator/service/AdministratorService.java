package com.wang.boot.pt.parttimes.administrator.service;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:24
 *@description:
 */

import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;

import java.util.List;

public interface AdministratorService {
    //保存
    public int insertByObject(AdministratorDto dto);

    //修改密码
    public int updatePass(AdministratorDto dto);

    //根据用户名密码判断是否存在数据
    public List<AdministratorDto> selectByCodePass(String code,String pass);

    //根据用户名得到密码
    public List<AdministratorDto> selectPassByCode(String code, String pass);

    //根据用户名删除数据
    public int deleteByCode(String code);

    public List<AdministratorDto> selectByCode(String code);
}
