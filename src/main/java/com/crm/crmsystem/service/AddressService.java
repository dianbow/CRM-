package com.crm.crmsystem.service;

import com.crm.crmsystem.constant.ResponseDataConstants;
import com.crm.crmsystem.dao.AddressMapper;
import com.crm.crmsystem.dao.model.Address;
import com.jieyuechina.bdc.common.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  private AddressMapper addressMapper;


  public ResponseData<String> saveAddress(Address address) {

    if (address.getConId()==null||address.getConId().equals("")) {
      if (address.getCusId() == null || address.getCusId().equals("")) {
        return ResponseData.ok(ResponseDataConstants.ADDRESS_ERRO);
      }
    }
    int insert = addressMapper.insert(address);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseDataConstants.OPERATE_SUCCESS);
  }

  public ResponseData<Address> selAddByCusIdOrConId(Address address) {

    if (address.getConId()==null||address.getConId().equals("")) {
      if (address.getCusId() == null || address.getCusId().equals("")) {
        return ResponseData.ok(ResponseDataConstants.ADDRESS_ERRO);
      }
    }

    Address address1 = addressMapper.selAddByCusIdOrConId(address);
    return ResponseData.ok(address1);
  }

  public ResponseData<Address> delAddByCusIdOrConId(Address address) {

    if (address.getConId()==null||address.getConId().equals("")) {
      if (address.getCusId() == null || address.getCusId().equals("")) {
        return ResponseData.ok(ResponseDataConstants.ADDRESS_ERRO);
      }
    }
    int insert = addressMapper.delAddByCusIdOrConId(address);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseData.SUCCESS);
  }

  public ResponseData<Address> modAddByCusIdOrConId(Address address) {

    if (address.getConId()==null||address.getConId().equals("")) {
      if (address.getCusId() == null || address.getCusId().equals("")) {
        return ResponseData.ok(ResponseDataConstants.ADDRESS_ERRO);
      }
    }
    int insert = addressMapper.modAddByCusIdOrConId(address);
    if (insert==0){
      return ResponseData.ok(ResponseDataConstants.SYSTEM_ERRO);
    }
    return ResponseData.ok(ResponseData.SUCCESS);
  }
}
