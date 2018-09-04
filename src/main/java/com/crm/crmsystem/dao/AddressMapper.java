package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    //根据客户ID或者联系人ID查询地址
    Address selAddByCusIdOrConId(Address address);

}