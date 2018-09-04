package com.crm.crmsystem.dao.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Customer implements Serializable {
    private Integer id;

    private Integer userId;

    private String cusName;

    private String cusLevel;

    private String cusPhone;

    private String cusAddress;

    private String cusEmail;

    private Integer cusParentId;

    private String cusWeb;

    private String cusNumber;

    private Integer cusShares;

    private Integer cusTypeId;

    private String cusOwnership;

    private Integer cusIndustryId;

    private Integer cusEmployeesNum;

    private String cusAnnualIncome;

    private String cusSic;

    private String cusDes;

    private Integer isvalid;

    //客户所属联系人
    private User user;

    private static final long serialVersionUID = 1L;

}