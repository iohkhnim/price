package com.khoi.price.dao.dao.impl;

import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.price.dao.IPriceDAO;
import com.khoi.price.dto.Price;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ImplPriceDAO extends BaseDAOImpl<Price, Integer> implements IPriceDAO {

}
