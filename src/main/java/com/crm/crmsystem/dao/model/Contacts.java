package com.crm.crmsystem.dao.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Contacts implements Serializable {
    private Integer id;

    private Integer cusId;

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

    private Customer customer;

    private static final long serialVersionUID = 1L;

}