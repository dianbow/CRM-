package com.crm.crmsystem.form.vo;

import lombok.Data;

/**
 * @author wudianbo
 * @date 2018-08-09 10:52
 */
@Data
public class PageForm<T> {
  T form;
  private int pageIndex = 1;
  private int pageSize = 10;
  private String sort;
  private String order;
}
