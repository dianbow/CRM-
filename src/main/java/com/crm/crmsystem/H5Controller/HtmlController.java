package com.crm.crmsystem.H5Controller;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.controller.CustomerController;
import com.crm.crmsystem.controller.UserController;
import com.crm.crmsystem.dao.model.Customer;
import com.crm.crmsystem.dao.model.User;
import com.crm.crmsystem.form.vo.PageForm;
import com.jieyuechina.bdc.common.model.ResponseData;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("crm/page/")
public class HtmlController {

  @Autowired
  private UserController userController;
  @Autowired
  private CustomerController customerController;

  @GetMapping("login")
  public String logon() {

    return "login";
  }

  @PostMapping("loginIn")
  public String loginIn(User user, HttpServletRequest request) {

    JSONObject jsonUser = JSONObject.fromObject(user);

    System.out.println("用户登录请求报文:" + jsonUser);
    ResponseData<String> login = userController.login(user);
    JSONObject loginUser = JSONObject.fromObject(login);

    System.out.println("用户登录返回报文:" + loginUser);

    request.getSession().setAttribute("msg", login.getData());
    if (login.getData().equals(ResponseDataConstants.OPERATE_SUCCESS)) {
      request.getSession().setAttribute("user", user);
      return "index";
    }
    return "login";
  }

  @GetMapping("customer")
  public String customer(HttpServletRequest request) {
    Customer customer = new Customer();
    PageForm<Customer> pageForm = new PageForm();
    pageForm.setForm(customer);
    ResponseData<String> listCustomer = customerController.selAllCus(pageForm);
    request.setAttribute("listCustomer", listCustomer);
    return "customer";
  }
}
