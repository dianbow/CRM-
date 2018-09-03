package com.crm.crmsystem.dao.model;

import java.io.Serializable;

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

    private String cusTypeId;

    private String cusOwnership;

    private Integer cusIndustryId;

    private Integer cusEmployeesNum;

    private String cusAnnualIncome;

    private String cusSic;

    private String cusDes;

    private Integer isvalid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel == null ? null : cusLevel.trim();
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone == null ? null : cusPhone.trim();
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress == null ? null : cusAddress.trim();
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail == null ? null : cusEmail.trim();
    }

    public Integer getCusParentId() {
        return cusParentId;
    }

    public void setCusParentId(Integer cusParentId) {
        this.cusParentId = cusParentId;
    }

    public String getCusWeb() {
        return cusWeb;
    }

    public void setCusWeb(String cusWeb) {
        this.cusWeb = cusWeb == null ? null : cusWeb.trim();
    }

    public String getCusNumber() {
        return cusNumber;
    }

    public void setCusNumber(String cusNumber) {
        this.cusNumber = cusNumber == null ? null : cusNumber.trim();
    }

    public Integer getCusShares() {
        return cusShares;
    }

    public void setCusShares(Integer cusShares) {
        this.cusShares = cusShares;
    }

    public String getCusTypeId() {
        return cusTypeId;
    }

    public void setCusTypeId(String cusTypeId) {
        this.cusTypeId = cusTypeId == null ? null : cusTypeId.trim();
    }

    public String getCusOwnership() {
        return cusOwnership;
    }

    public void setCusOwnership(String cusOwnership) {
        this.cusOwnership = cusOwnership == null ? null : cusOwnership.trim();
    }

    public Integer getCusIndustryId() {
        return cusIndustryId;
    }

    public void setCusIndustryId(Integer cusIndustryId) {
        this.cusIndustryId = cusIndustryId;
    }

    public Integer getCusEmployeesNum() {
        return cusEmployeesNum;
    }

    public void setCusEmployeesNum(Integer cusEmployeesNum) {
        this.cusEmployeesNum = cusEmployeesNum;
    }

    public String getCusAnnualIncome() {
        return cusAnnualIncome;
    }

    public void setCusAnnualIncome(String cusAnnualIncome) {
        this.cusAnnualIncome = cusAnnualIncome == null ? null : cusAnnualIncome.trim();
    }

    public String getCusSic() {
        return cusSic;
    }

    public void setCusSic(String cusSic) {
        this.cusSic = cusSic == null ? null : cusSic.trim();
    }

    public String getCusDes() {
        return cusDes;
    }

    public void setCusDes(String cusDes) {
        this.cusDes = cusDes == null ? null : cusDes.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }
}