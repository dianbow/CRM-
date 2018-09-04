package com.crm.crmsystem.dao.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private Integer id;

    private Integer cusId;

    private Integer conId;

    private String contry;

    private String province;

    private String city;

    private String street;

    private Integer isvalid;

    private Integer type;

    private static final long serialVersionUID = 1L;


}