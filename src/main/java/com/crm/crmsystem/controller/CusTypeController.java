package com.crm.crmsystem.controller;

import com.crm.crmsystem.dao.model.Contacts;
import com.crm.crmsystem.dao.model.CusType;
import com.crm.crmsystem.form.vo.PageForm;
import com.crm.crmsystem.service.CusTypeService;
import com.jieyuechina.bdc.common.model.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "CusType客户类型接口文档")
@RestController
@RequestMapping("crm/cusType/")
public class CusTypeController {

  @Autowired
  private CusTypeService cusTypeService;

  @RequestMapping(value = "addCusType",method = POST)
  @ApiOperation(value = "添加客户类型", notes = "添加客户类型")
  public ResponseData<String> addCusType(@RequestBody CusType cusType){

    return cusTypeService.addCusType(cusType);
  }
  @RequestMapping(value = "delCusType/{id}",method = GET)
  @ApiOperation(value = "删除客户类型", notes = "删除客户类型")
  public ResponseData<String> delCusType(@PathVariable("id") int id){

    return cusTypeService.delCusType(id);
  }

  @RequestMapping(value = "modCusType",method = POST)
  @ApiOperation(value = "修改客户类型", notes = "修改客户类型")
  public ResponseData<String> modCusType(@RequestBody CusType cusType){

    return cusTypeService.modCusType(cusType);
  }

  @RequestMapping(value = "selCusType",method = POST)
  @ApiOperation(value = "按条件查询所有客户类型", notes = "查询所有客户类型（id,名称）")
  public ResponseData<String> selCusType(@RequestBody PageForm<CusType> pageForm){

    return cusTypeService.selCusType(pageForm);
  }
}
