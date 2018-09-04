package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.CusType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CusTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CusType record);

    int insertSelective(CusType record);

    CusType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusType record);

    int updateByPrimaryKey(CusType record);

    //分页条件查询
    List<CusType> selCusType(@Param("form") CusType form);
}