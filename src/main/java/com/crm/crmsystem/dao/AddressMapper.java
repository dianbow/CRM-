package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    //根据客户ID或者联系人ID+type查询地址
    Address selAddByCusIdOrConId(@Param("address") Address address);

    //根据客户ID或者联系人ID+type删除地址
    int delAddByCusIdOrConId(@Param("address") Address address);

    //根据客户ID或者联系人ID+type修改地址
    int modAddByCusIdOrConId(@Param("address") Address address);
}