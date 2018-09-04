package com.crm.crmsystem.controller;

import com.crm.crmsystem.dao.model.Address;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.form.vo.PageForm;
import com.crm.crmsystem.service.AddressService;
import com.crm.crmsystem.service.CustomerService;
import com.jieyuechina.bdc.common.model.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("crm/cus/")
@Api(description="客户管理接口")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "addCus",method = POST)
  @ApiOperation(value = "添加客户", notes = "添加客户")
  public ResponseData<String> addCus(@RequestBody Customer customer){

    return customerService.addCus(customer);
  }
  @RequestMapping(value = "delCus/{id}",method = GET)
  @ApiOperation(value = "删除客户", notes = "删除客户")
  public ResponseData<String> delCus(@PathVariable("id") int id){

    return customerService.delCus(id);
  }
  @RequestMapping(value = "modCus",method = POST)
  @ApiOperation(value = "修改客户信息", notes = "修改客户信息")
  public ResponseData<String> modCus(@RequestBody Customer customer){

    return customerService.modCus(customer);
  }
  @RequestMapping(value = "selAllCus",method = POST)
  @ApiOperation(value = "按条件查询所有客户", notes = "查询所有客户（用户，地址，客户名，type,industry，父客户）")
  public ResponseData<String> selAllCus(@RequestBody PageForm<Customer> pageForm){

    return customerService.selAllCus(pageForm);
  }

}
