package com.crm.crmsystem.dao.model;

import java.io.Serializable;

public class CusType implements Serializable {
    private Integer id;

    private String custypeName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustypeName() {
        return custypeName;
    }

    public void setCustypeName(String custypeName) {
        this.custypeName = custypeName == null ? null : custypeName.trim();
    }
}