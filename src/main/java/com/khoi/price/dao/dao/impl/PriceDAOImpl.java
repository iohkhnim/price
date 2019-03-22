package com.khoi.price.dao.dao.impl;

import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.price.dao.IPriceDAO;
import com.khoi.price.dto.Price;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PriceDAOImpl extends BaseDAOImpl<Price, Integer> implements IPriceDAO {

  /**
   * <p>This method gets the newest price of given product ID</p>
   * @param product_id product ID needs to be retrieved price
   * @return price of given product ID
   */
  public int findPrice(int product_id) {
    String hql = "SELECT obj.price FROM Price obj WHERE obj.product_id = :prodid ORDER BY obj.createdTime DESC";
    Query query = entityManager.createQuery(hql);
    query.setParameter("prodid", product_id);
    return Integer.parseInt(query.setMaxResults(1).getSingleResult().toString());
  }

  /**
   * <p>This method gets all prices of given product ID</p>
   * @param product_id product ID needs to be retrieved all prices
   * @return prices of given product ID
   */
  public List<Integer> findPrices(int product_id) {
    String hql = "SELECT obj.price FROM Price obj WHERE obj.product_id = " + product_id
        + " ORDER BY obj.createdTime DESC";
    Query query = entityManager.createQuery(hql, Integer.class);
    List<Integer> a = (List<Integer>) query.getResultList();
    return a;
  }

  /**
   * <p>This method gets list of Price object using provided product ID</p>
   * @param product_id product ID needs to be retrieved price history
   * @return List of Price objects
   */
  public List<Price> findProductPriceHistory(int product_id) {
    String hql = "FROM Price as price WHERE price.product_id = " + product_id
        + " ORDER BY price.createdTime DESC";
    return (List<Price>) entityManager.createQuery(hql, Price.class).getResultList();
  }

  /**
   * <p>This method deletes all prices related to given product ID</p>
   * @param product_id product ID needs to be deleted all its prices
   * @return Return a boolean value according to result
   */
  public Boolean deleteByProductId(int product_id) {
    try {
      String hql = "DELETE FROM Price p WHERE p.product_id = :pid";
      Query query = entityManager.createQuery(hql).setParameter("pid", product_id);
      query.executeUpdate();
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

}
