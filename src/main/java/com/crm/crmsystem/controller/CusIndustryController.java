package com.crm.crmsystem.controller;

import com.crm.crmsystem.dao.model.CusIndustry;
import com.crm.crmsystem.dao.model.CusType;
import com.crm.crmsystem.form.vo.PageForm;
import com.crm.crmsystem.service.CusIndustryService;
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

@Api(description = "CusIndustry行业接口文档")
@RestController
@RequestMapping("crm/cusIndustry/")
public class CusIndustryController {

  @Autowired
  private CusIndustryService cusIndustryService;

  @RequestMapping(value = "addCusIndustry",method = POST)
  @ApiOperation(value = "添加行业", notes = "添加行业")
  public ResponseData<String> addCusIndustry(@RequestBody CusIndustry cusIndustry){

    return cusIndustryService.addCusIndustry(cusIndustry);
  }
  @RequestMapping(value = "delCusIndustry/{id}",method = GET)
  @ApiOperation(value = "删除行业", notes = "删除行业")
  public ResponseData<String> delCusIndustry(@PathVariable("id") int id){

    return cusIndustryService.delCusIndustry(id);
  }

  @RequestMapping(value = "modCusIndustry",method = POST)
  @ApiOperation(value = "修改行业", notes = "修改行业")
  public ResponseData<String> modCusIndustry(@RequestBody CusIndustry cusIndustry){

    return cusIndustryService.modCusIndustry(cusIndustry);
  }

  @RequestMapping(value = "selCusIndustry",method = POST)
  @ApiOperation(value = "按条件查询所有行业", notes = "查询所有行业（id,名称）")
  public ResponseData<String> selCusIndustry(@RequestBody PageForm<CusIndustry> pageForm){

    return cusIndustryService.selCusIndustry(pageForm);
  }
}
