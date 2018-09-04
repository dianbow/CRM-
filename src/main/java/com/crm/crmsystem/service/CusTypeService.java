package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.CusTypeMapper;
import com.crm.crmsystem.dao.model.Contacts;
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
public class CusTypeService {

  @Autowired
  private CusTypeMapper cusTypeMapper;

  public ResponseData<String> addCusType(CusType cusType) {

    int insert = cusTypeMapper.insert(cusType);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> delCusType(int id) {

    int insert = cusTypeMapper.deleteByPrimaryKey(id);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> modCusType(CusType cusType) {

    int insert = cusTypeMapper.updateByPrimaryKeySelective(cusType);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> selCusType(PageForm<CusType> pageForm) {

    Page page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
    List<CusType> cusTypes = cusTypeMapper.selCusType(pageForm.getForm());
    PageInfo pageInfo = new PageInfo();
    pageInfo.setTotalRecords(Double.valueOf(page.getTotal()).intValue());
    return ResponseData.ok(cusTypes,pageInfo);
  }
}
