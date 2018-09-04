package com.crm.crmsystem.controller;


import com.crm.crmsystem.dao.model.User;
import com.crm.crmsystem.form.group.Opetate;
import com.crm.crmsystem.form.vo.PageForm;
import com.crm.crmsystem.service.UserService;
import com.crm.crmsystem.utils.MD5;
import com.jieyuechina.bdc.common.model.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("crm/user/")
@Api(description="用户管理接口")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 用户登录
   * @param user
   * @return
   */
  @RequestMapping(value = "login",method = POST)
  @ApiOperation(value = "用户登录", notes = "用户名+密码登录")
  public ResponseData<String> login(@RequestBody @Validated(Opetate.Login.class) User user){

    //密码加密
    //MD5JIAMI(user);
    user.setPassword(MD5.encode(user.getUsername()+user.getPassword()));

    return userService.selectUser(user);
  }

  /**
   * 添加用户
   * @param user
   * @return
   */
  @ApiOperation(value = "添加用户", notes = "添加用户，邮箱、用户名、密码不能为空")
  @RequestMapping(value = "saveUser",method = POST)
  public ResponseData<String>  saveUser(@RequestBody @Validated(Opetate.Create.class) User user) throws NoSuchAlgorithmException {


    //去除用户名空格
    String username = user.getUsername().replace(" ","");
    user.setUsername(username);

    //密码加密
    //MD5JIAMI(user);
    user.setPassword(MD5.encode(user.getUsername()+user.getPassword()));
    return userService.addUser(user);
  }

  /**
   * 修改用户信息
   * @param user
   */
  @ApiOperation(value = "修改用户信息", notes = "修改用户邮箱，密码，昵称等信息，用户名不可修改")
  @RequestMapping(value = "modifyUser",method = POST)
  public ResponseData<String>  modifyUser(@RequestBody @Validated(Opetate.Update.class) User user) throws NoSuchAlgorithmException {

    //密码加密
    //MD5JIAMI(user);
    user.setPassword(MD5.encode(user.getUsername()+user.getPassword()));

    return userService.updateUser(user);
  }

  /**
   * 用户失效
   * @param user
   * @return
   * @throws NoSuchAlgorithmException
   */
  @ApiOperation(value = "用户失效", notes = "更新用户isValid状态，不珊库")
  @RequestMapping(value = "invalidUser",method = POST)
  public ResponseData<String>  invalidUser(@RequestBody @Validated(Opetate.Delete.class) User user) throws NoSuchAlgorithmException {

    return userService.deleteUserByIsValid(user);
  }

  /**
   * 永久删除用户
   * @param user
   * @return
   * @throws NoSuchAlgorithmException
   */
  @ApiOperation(value = "永久删除用户", notes = "从数据库中永久删除用户")
  @RequestMapping(value = "removeUser",method = POST)
  public ResponseData<String>  removeUser(@RequestBody @Validated(Opetate.Delete.class) User user) throws NoSuchAlgorithmException {

    return userService.deleteUser(user);
  }

  /**
   * 用户查询(用户名模糊查询，分页查询)
   * @param pageForm
   */
  @ApiOperation(value = "用户查询", notes = "用户名模糊查询，分页查询")
  @RequestMapping(value = "queryUsers",method = POST)
  public ResponseData<List<User>> queryUsers(@RequestBody PageForm<User> pageForm) throws NoSuchAlgorithmException {

    return userService.selectUsers(pageForm);
  }


  private void MD5JIAMI(User user){
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      BASE64Encoder base64en = new BASE64Encoder();
      String newPassword = base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
      user.setPassword(newPassword);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

  }
}
