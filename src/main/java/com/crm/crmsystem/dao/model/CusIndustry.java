package com.crm.crmsystem.dao.model;

import java.io.Serializable;

public class CusIndustry implements Serializable {
    private Integer id;

    private String industryName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }
}