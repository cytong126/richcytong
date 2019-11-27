package com.wang.boot.pt.parttimes.administrator.mapper;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:28
 *@description:
 */

import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface AdministratorMapper {

    //保存
    @Insert("insert into sys_administrator(code,name,pass,status,description)" +
            " VALUES(#{code , jdbcType=VARCHAR},#{name , jdbcType=VARCHAR},#{pass , jdbcType=VARCHAR},#{status , jdbcType=INTEGER},#{description , jdbcType=VARCHAR})")
    public int insertByObject(AdministratorDto dto);

    //修改密码
    @Update(" update sys_administrator " +
            " set pass=#{pass , jdbcType=VARCHAR} " +
            " where " +
            " code=#{code , jdbcType=INTEGER}")
    public int updatePass(AdministratorDto dto);

    //根据用户名密码判断是否存在数据
    @Select("select code,pass from sys_administrator where code=#{code , jdbcType=VARCHAR} and pass=#{pass , jdbcType=VARCHAR}  " )
    @Results({
            @Result(column = "code",property = "code"),
            @Result(column = "pass",property = "pass")
    })
    public List<AdministratorDto> selectByCodePass(String code,String pass);

    //根据用户名得到密码
    @Select("select pass from sys_administrator where code=#{code , jdbcType=VARCHAR} " )
    @Results({
            @Result(column = "pass",property = "pass")
    })
    public List<AdministratorDto> selectPassByCode(String code,String pass);

    //根据用户名得到其他信息
    @Select("select name,status,description from sys_administrator where code=#{code , jdbcType=VARCHAR} " )
    @Results({
            @Result(column = "name",property = "name"),
            @Result(column = "status",property = "status"),
            @Result(column = "description",property = "description")
    })
    public List<AdministratorDto> selectByCode(String code);




    //根据用户名删除数据
    @Delete("delete from sys_administrator where code=#{code , jdbcType=VARCHAR}")
    public int deleteByCode(String code);


}
