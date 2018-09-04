package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.ContactsMapper;
import com.crm.crmsystem.dao.model.Contacts;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.form.vo.PageForm;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jieyuechina.bdc.common.model.PageInfo;
import com.jieyuechina.bdc.common.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

  @Autowired
  private ContactsMapper contactsMapper;

  public ResponseData<String> addCon(Contacts contacts) {


    int insert = contactsMapper.insert(contacts);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> delCon(int id) {

    int insert = contactsMapper.deleteById(id);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> modCon(Contacts contacts) {

    int insert = contactsMapper.updateByPrimaryKeySelective(contacts);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }

    return ResponseData.ok();
  }

  public ResponseData<String> selAllCon(PageForm<Contacts> pageForm) {

    Page page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
    List<Contacts> contacts = contactsMapper.selectAllCustomer(pageForm.getForm());
    PageInfo pageInfo = new PageInfo();
    pageInfo.setTotalRecords(Double.valueOf(page.getTotal()).intValue());
    return ResponseData.ok(contacts,pageInfo);
  }
}
