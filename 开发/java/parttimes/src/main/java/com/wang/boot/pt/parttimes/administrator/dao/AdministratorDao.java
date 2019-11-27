package com.wang.boot.pt.parttimes.administrator.dao;

import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.administrator.mapper.AdministratorMapper;
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
public class AdministratorDao {

    @Autowired
    private AdministratorMapper mapper;

    //保存
    public int insertByObject(AdministratorDto dto){
        return mapper.insertByObject(dto);
    }

    //修改密码
    public int updatePass(AdministratorDto dto){
        return mapper.updatePass(dto);
    }

    //根据用户名密码判断是否存在数据
    public List<AdministratorDto> selectByCodePass(String code,String pass){
        return mapper.selectByCodePass(code,pass);
    }

    //根据用户名得到密码
    public List<AdministratorDto> selectPassByCode(String code,String pass){
        return mapper.selectPassByCode(code,pass);
    }
    //根据用户名删除数据
    public int deleteByCode(String code){
        return mapper.deleteByCode(code);
    }

    public List<AdministratorDto> selectByCode(String code){
        return mapper.selectByCode(code);
    }

}
