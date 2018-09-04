package com.crm.crmsystem.controller;


import com.crm.crmsystem.dao.model.Contacts;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.form.vo.PageForm;
import com.crm.crmsystem.service.ContactsService;
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

@Api(description="联系人接口")
@RestController
@RequestMapping("crm/con/")
public class ContactsController {

  @Autowired
  private ContactsService contactsService;

  @RequestMapping(value = "addCon",method = POST)
  @ApiOperation(value = "添加联系人", notes = "添加联系人")
  public ResponseData<String> addCon(@RequestBody Contacts contacts){

    return contactsService.addCon(contacts);
  }

  @RequestMapping(value = "delCon/{id}",method = GET)
  @ApiOperation(value = "删除联系人", notes = "删除客户")
  public ResponseData<String> delCon(@PathVariable("id") int id){

    return contactsService.delCon(id);
  }
  @RequestMapping(value = "modCon",method = POST)
  @ApiOperation(value = "修改客户信息", notes = "修改客户信息")
  public ResponseData<String> modCon(@RequestBody Contacts contacts){

    return contactsService.modCon(contacts);
  }
  @RequestMapping(value = "selAllCon",method = POST)
  @ApiOperation(value = "按条件查询所有客户", notes = "查询所有客户（id,用户id，电话，客户id,邮箱,姓名）")
  public ResponseData<String> selAllCon(@RequestBody PageForm<Contacts> pageForm){

    return contactsService.selAllCon(pageForm);
  }
}
