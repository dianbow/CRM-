package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.CustomerMapper;
import com.crm.crmsystem.dao.UserMapper;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.dao.model.User;
import com.crm.crmsystem.form.vo.PageForm;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jieyuechina.bdc.common.model.PageInfo;
import com.jieyuechina.bdc.common.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerMapper customerMapper;
  @Autowired
  private UserMapper userMapper;
  public ResponseData<String> addCus(Customer customer) {

    if (customer.getUserId()==null||customer.getUserId().equals("")){
      return ResponseData.ok(ResponseDataConstants.USER_ERRO);

    }

    int insert = customerMapper.insert(customer);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> delCus(int id) {

    int insert = customerMapper.deleteById(id);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> selAllCus(PageForm<Customer> pageForm) {

    if (pageForm.getForm().getUser()!=null){
      if (pageForm.getForm().getUser().getUsername()!=null&&pageForm.getForm().getUser().getUsername()!=""){
        User user = userMapper.selectUserByUsername(pageForm.getForm().getUser().getUsername());
        pageForm.getForm().setUserId(user.getId());
      }
    }
    Page page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
    List<Customer> customers = customerMapper.selectAllCustomer(pageForm.getForm());

    for (int i=0; i<customers.size();i++){
      Customer customer = customers.get(i);
      User user = userMapper.selectByPrimaryKey(customer.getUserId());
      customer.setUser(user);
    }
    PageInfo pageInfo = new PageInfo();
    pageInfo.setTotalRecords(Double.valueOf(page.getTotal()).intValue());
    return ResponseData.ok(customers,pageInfo);
  }

  public ResponseData<String> modCus(Customer customer) {

    int insert = customerMapper.updateByPrimaryKeySelective(customer);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }
}
