package com.khoi.price.dao;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.price.dto.Price;
import java.util.List;

public interface IPriceDAO extends IBaseDAO<Price, Integer> {

  List<Integer> findPrices(int product_id);

  //public List<Integer> findPrice(int product_id);

  List<Price> findProductPriceHistory(int product_id);

  int findPrice2(int product_id);

  Boolean deleteByProductId(int product_id);
}
