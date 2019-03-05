package com.khoi.price.service.service.impl;

import com.khoi.basecrud.service.service.impl.BaseServiceImpl;
import com.khoi.price.dto.Price;
import com.khoi.price.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl extends BaseServiceImpl<Price, Integer> implements IPriceService {
  /*I< Foo > dao;

  @Autowired
  public void setDao( IGenericDao< Foo > daoToSet ){
    dao = daoToSet;
    dao.setClazz( Foo.class );
  }*/
}
