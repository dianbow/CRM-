package com.crm.crmsystem.H5Controller;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.controller.CustomerController;
import com.crm.crmsystem.controller.UserController;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.dao.model.User;
import com.crm.crmsystem.form.vo.PageForm;
import com.jieyuechina.bdc.common.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

@Slf4j
@Controller
@RequestMapping("crm/page/")
public class HtmlController {

  @Autowired
  private UserController userController;
  @Autowired
  private CustomerController customerController;

  /**
   * 跳转登录页
   * @return
   */
  @GetMapping("login")
  public String logon() {

    return "login";
  }

  /**
   * 用户登录
   * @param user
   * @param request
   * @return
   */
  @PostMapping("loginIn")
  public String loginIn(User user, HttpServletRequest request) {

    JSONObject jsonUser = JSONObject.fromObject(user);
    log.info("用户登录请求报文:{}",jsonUser);

    ResponseData<String> login = userController.login(user);
    JSONObject loginUser = JSONObject.fromObject(login);
    log.info("用户登录返回报文:{}",loginUser);

    request.getSession().setAttribute("msg", login.getData());
    if (login.getData().equals(ResponseDataConstants.OPERATE_SUCCESS)) {
      request.getSession().setAttribute("user", user);
      return "index";
    }
    return "login";
  }

  /**
   * 跳转客户列表页
   * @param request
   * @return
   */
  @GetMapping("customer")
  public String customer(HttpServletRequest request) {
    PageForm<Customer> pageForm = new PageForm();
    Customer customer=new Customer();
    pageForm.setForm(customer);
    ResponseData<String> listCustomer = customerController.selAllCus(pageForm);
    request.setAttribute("listCustomer", listCustomer);
    return "customer";
  }

  /**
   * 客户分页+条件查询
   * @param pageIndex
   * @return
   */
  @PostMapping("customerPage")
  @ResponseBody
  public ResponseData<String> customer(int pageIndex,String cusName,String username) {
    PageForm<Customer> pageForm = new PageForm();
    Customer customer=new Customer();
    if (cusName!=null&&cusName!=""){
      customer.setCusName(cusName);
    }
    if (username!=null&&username!=""){
      User user=new User();
      user.setUsername(username);
      customer.setUser(user);
    }
    pageForm.setForm(customer);
    pageForm.setPageIndex(pageIndex);
    return customerController.selAllCus(pageForm);
  }
  /**
   * 客户条件查询
   */
  @PostMapping("queryCustomerPage")
  public String queryCustomerPage(Customer customer,HttpServletRequest request) {
    PageForm<Customer> pageForm = new PageForm();
    pageForm.setForm(customer);
    ResponseData<String> listCustomer = customerController.selAllCus(pageForm);

    String cusName = customer.getCusName();
    if (cusName!=null&&cusName!=""){
      request.setAttribute("cusName", cusName);
    }
    if (customer.getUser()!=null){
      String username = customer.getUser().getUsername();
      if (username!=null&&username!=""){
        request.setAttribute("username", username);
      }
    }
    request.setAttribute("listCustomer", listCustomer);
    return "customer";
  }
}
