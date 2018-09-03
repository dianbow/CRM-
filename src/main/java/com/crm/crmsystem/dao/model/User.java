package com.crm.crmsystem.dao.model;

import com.crm.crmsystem.form.group.Opetate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class User implements Serializable {


    @NotNull(message = "用户ID为空",groups = {Opetate.Update.class,Opetate.Delete.class})
    private Integer id;

    @ApiModelProperty(name="email",value="用户邮箱",required=true,example="wdb@163.com")
    @NotBlank(message = "邮箱不能为空",groups = {Opetate.Create.class,Opetate.Update.class})
    private String email;

    @ApiModelProperty(name="username",value="用户名",required=true,example="wdb")
    @NotBlank(message = "用户名不能为空",groups = {Opetate.Create.class,Opetate.Login.class})
    private String username;

    @ApiModelProperty(name="password",value="密码",required=true,example="abc123")
    @NotBlank(message = "密码不能为空",groups = {Opetate.Create.class,Opetate.Login.class,Opetate.Update.class})
    private String password;

    @ApiModelProperty(name="nickname",value="用户昵称",required=true,example="吴殿波")
    private String nickname;

    @ApiModelProperty(name="age",value="年龄",required=true,example="18")
    private Integer age;

    @ApiModelProperty(name="phone",value="电话",required=true,example="15510534501")
    private String phone;

    private Integer isvalid;

    @ApiModelProperty(name="createTime",value="用户创建时间",required=true,example="2018-08-29T11:55:01.456+0000")
    private Date createTime;

    @ApiModelProperty(name="modifyTime",value="用户修改时间",required=true,example="2018-08-29T11:55:01.456+0000")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;


}