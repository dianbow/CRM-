package com.crm.crmsystem.dao.model;

import java.io.Serializable;

public class Contacts implements Serializable {
    private Integer id;

    private Integer cusId;

    private Integer userId;

    private String conName;

    private Integer supplierId;

    private String conSource;

    private String conEmail;

    private String conEmail2;

    private String conDepartment;

    private String conPosition;

    private String conPhone;

    private String conTel;

    private String conTel2;

    private String conBirthday;

    private String conAssistant;

    private String conAssistantPhone;

    private Integer conSendEmail;

    private String conReport;

    private Integer conSkypeId;

    private String conDes;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getConSource() {
        return conSource;
    }

    public void setConSource(String conSource) {
        this.conSource = conSource == null ? null : conSource.trim();
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail == null ? null : conEmail.trim();
    }

    public String getConEmail2() {
        return conEmail2;
    }

    public void setConEmail2(String conEmail2) {
        this.conEmail2 = conEmail2 == null ? null : conEmail2.trim();
    }

    public String getConDepartment() {
        return conDepartment;
    }

    public void setConDepartment(String conDepartment) {
        this.conDepartment = conDepartment == null ? null : conDepartment.trim();
    }

    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition == null ? null : conPosition.trim();
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone == null ? null : conPhone.trim();
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel == null ? null : conTel.trim();
    }

    public String getConTel2() {
        return conTel2;
    }

    public void setConTel2(String conTel2) {
        this.conTel2 = conTel2 == null ? null : conTel2.trim();
    }

    public String getConBirthday() {
        return conBirthday;
    }

    public void setConBirthday(String conBirthday) {
        this.conBirthday = conBirthday == null ? null : conBirthday.trim();
    }

    public String getConAssistant() {
        return conAssistant;
    }

    public void setConAssistant(String conAssistant) {
        this.conAssistant = conAssistant == null ? null : conAssistant.trim();
    }

    public String getConAssistantPhone() {
        return conAssistantPhone;
    }

    public void setConAssistantPhone(String conAssistantPhone) {
        this.conAssistantPhone = conAssistantPhone == null ? null : conAssistantPhone.trim();
    }

    public Integer getConSendEmail() {
        return conSendEmail;
    }

    public void setConSendEmail(Integer conSendEmail) {
        this.conSendEmail = conSendEmail;
    }

    public String getConReport() {
        return conReport;
    }

    public void setConReport(String conReport) {
        this.conReport = conReport == null ? null : conReport.trim();
    }

    public Integer getConSkypeId() {
        return conSkypeId;
    }

    public void setConSkypeId(Integer conSkypeId) {
        this.conSkypeId = conSkypeId;
    }

    public String getConDes() {
        return conDes;
    }

    public void setConDes(String conDes) {
        this.conDes = conDes == null ? null : conDes.trim();
    }
}