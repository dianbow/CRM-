package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.CusIndustryMapper;
import com.crm.crmsystem.dao.model.CusIndustry;
import com.crm.crmsystem.dao.model.CusType;
import com.crm.crmsystem.form.vo.PageForm;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jieyuechina.bdc.common.model.PageInfo;
import com.jieyuechina.bdc.common.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusIndustryService {

  @Autowired
  private CusIndustryMapper cusIndustryMapper;

  public ResponseData<String> addCusIndustry(CusIndustry cusIndustry) {
    int insert = cusIndustryMapper.insert(cusIndustry);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> delCusIndustry(int id) {
    int insert = cusIndustryMapper.deleteByPrimaryKey(id);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> modCusIndustry(CusIndustry cusIndustry) {
    int insert = cusIndustryMapper.updateByPrimaryKeySelective(cusIndustry);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> selCusIndustry(PageForm<CusIndustry> pageForm) {

    Page page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
    List<CusIndustry> cusIndustries = cusIndustryMapper.selCusType(pageForm.getForm());
    PageInfo pageInfo = new PageInfo();
    pageInfo.setTotalRecords(Double.valueOf(page.getTotal()).intValue());
    return ResponseData.ok(cusIndustries,pageInfo);
  }
}
