package com.crm.crmsystem.form.vo;

import com.crm.crmsystem.constant.ResponseDataConstants;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author qiyc
 * @date 2018-08-23 15:14
 */
@Data
public class DatasForm<T> {
  @NotEmpty(message = ResponseDataConstants.DATAS_EMPTY)
  private List<T> datas;
}
