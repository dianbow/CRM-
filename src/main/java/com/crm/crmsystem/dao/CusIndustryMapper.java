package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.CusIndustry;

public interface CusIndustryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CusIndustry record);

    int insertSelective(CusIndustry record);

    CusIndustry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusIndustry record);

    int updateByPrimaryKey(CusIndustry record);
}