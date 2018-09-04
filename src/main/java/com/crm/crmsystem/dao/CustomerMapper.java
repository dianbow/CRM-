package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //按条件分页查询所有客户
    List<Customer> selectAllCustomer(@Param("form")Customer customer);

    //删除客户
    int deleteById(int id);
}