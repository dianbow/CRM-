package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.CusIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CusIndustryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CusIndustry record);

    int insertSelective(CusIndustry record);

    CusIndustry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusIndustry record);

    int updateByPrimaryKey(CusIndustry record);

    //条件分页查询
    List<CusIndustry> selCusType(@Param("form") CusIndustry form);
}