package com.crm.crmsystem.controller;


import com.crm.crmsystem.dao.model.Address;
import com.crm.crmsystem.service.AddressService;
import com.jieyuechina.bdc.common.model.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("address/")
@Api(description="地址管理接口")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @RequestMapping(value = "addAddress",method = POST)
  @ApiOperation(value = "添加地址", notes = "添加地址model")
  public ResponseData<String> addAddress(@RequestBody Address address){

    return addressService.saveAddress(address);
  }

  @RequestMapping(value = "selAddByCusIdOrConId",method = POST)
  @ApiOperation(value = "查询地址", notes = "根据客户ID或者联系人ID查询地址")
  public ResponseData<Address> selAddByCusIdOrConId(@RequestBody Address address){

    return addressService.selAddByCusIdOrConId(address);
  }
}
