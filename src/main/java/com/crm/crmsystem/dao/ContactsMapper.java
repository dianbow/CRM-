package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.Contacts;
import com.crm.crmsystem.dao.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);

    //删除联系人
    int deleteById(Integer id);

    List<Contacts> selectAllCustomer(@Param("form") Contacts form);
}