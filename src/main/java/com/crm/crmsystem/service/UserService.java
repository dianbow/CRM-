package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.UserMapper;
import com.crm.crmsystem.dao.model.User;
import com.crm.crmsystem.form.vo.PageForm;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jieyuechina.bdc.common.model.PageInfo;
import com.jieyuechina.bdc.common.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public ResponseData<String> addUser(User user){

    //验证用户名不可重复
    User user1=userMapper.selectUserByUsername(user.getUsername());
    if (user1!=null){
      return ResponseData.ok(ResponseDataConstants.CATEGORY_NAME_EXIT);
    }

    int insert = userMapper.insert(user);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);
  }


  public ResponseData<String> selectUser(User user) {
    //根据用户名查询用户
    User user1=userMapper.selectUserByUsername(user.getUsername());
    if (user1==null){
      return ResponseData.ok(ResponseDataConstants.CATEGORY_NAME_NOEXIT);
    }

    //验证密码
    if (!user.getPassword().equals(user1.getPassword())){
      return ResponseData.ok(ResponseDataConstants.CATEGORY_PWD_ERRO);
    }

    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);

  }

  public ResponseData<String> updateUser(User user) {

    int i = userMapper.updateById(user);

    if (i==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);
  }

  public ResponseData<String> deleteUser(User user) {

    int i = userMapper.deleteByPrimaryKey(user.getId());

    if (i==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);
  }

  public ResponseData<String> deleteUserByIsValid(User user) {

    int i = userMapper.deleteByIsValid(user.getId());

    if (i==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);

  }

  public ResponseData<List<User>> selectUsers(PageForm<User> pageForm){

    Page page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
    List<User> users = userMapper.selectUsers(pageForm.getForm());
    PageInfo pageInfo = new PageInfo();
    pageInfo.setTotalRecords(Double.valueOf(page.getTotal()).intValue());
    return ResponseData.ok(users, pageInfo);
  }
}
