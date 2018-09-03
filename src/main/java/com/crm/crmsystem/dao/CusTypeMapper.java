package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.CusType;

public interface CusTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CusType record);

    int insertSelective(CusType record);

    CusType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusType record);

    int updateByPrimaryKey(CusType record);
}