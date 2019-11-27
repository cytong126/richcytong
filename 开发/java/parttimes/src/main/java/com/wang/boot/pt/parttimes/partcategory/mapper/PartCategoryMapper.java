package com.wang.boot.pt.parttimes.partcategory.mapper;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:28
 *@description:
 */

import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface PartCategoryMapper {


    @Insert("insert into part_category(category_name,category_type,create_time)" +
            " VALUES(#{categoryName , jdbcType=VARCHAR},#{categoryType , jdbcType=INTEGER},#{createTime , jdbcType=TIMESTAMP})")
    public int insertByObject(PartCategoryDto dto);


    @Insert("insert into part_category(category_name,category_type,create_time)" +
            " VALUES(#{categoryName , jdbcType=VARCHAR},#{categoryType , jdbcType=INTEGER},#{createTime , jdbcType=TIMESTAMP})")
    public int insertByMap(Map<String,Object> map);

    @Select("select * from part_category where category_name=#{categoryName , jdbcType=VARCHAR}  " )
    @Results({
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "create_time",property = "createTime")
    })
    public List<PartCategoryDto> selectByCategoryName(PartCategoryDto dto);

    @Select("<script>" +
            "select * from part_category" +
            " where 1=1 " +
            "<if test=\"categoryName !=null and categoryName !='' \"> and category_name like CONCAT('%',#{categoryName , jdbcType=VARCHAR},'%')  </if>" +
            "<if test=\"categoryType !=null \"> and category_type=#{categoryType , jdbcType=INTEGER}  </if>" +
            "<if test=\"status !=null \"> and status=#{status , jdbcType=INTEGER}  </if>" +
            "</script> " )
    @Results({
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "status",property = "status"),
            @Result(column = "sort",property = "sort")
    })
    public List<PartCategoryDto> selectByCon(PartCategoryDto dto);


    @Update(" update part_category " +
            " set category_name=#{categoryName , jdbcType=VARCHAR} " +
            " where " +
            " category_type=#{categoryType , jdbcType=INTEGER}")
    public int updateByCon1(String categoryName,int categoryType );

    @Update(" update part_category " +
            " set category_name=#{categoryName , jdbcType=VARCHAR} " +
            " where " +
            " category_type=#{categoryType , jdbcType=INTEGER}")
    public int updateByCon2(PartCategoryDto dto);



    public List<PartCategoryDto> selectByCategoryType(PartCategoryDto dto);

    public List<PartCategoryDto> selectByCategoryType2(int categoryType);




}
