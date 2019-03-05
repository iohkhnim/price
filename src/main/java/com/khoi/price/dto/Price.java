package com.khoi.price.dto;

import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "price")
public class Price extends baseDTO implements Serializable {

  /*@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;*/

  @Column(name = "product_id")
  private int product_id;

  /*@Column(name = "created_at", columnDefinition = "DATETIME")
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date createdTime;

  @Column(name = "updated_at", columnDefinition = "DATETIME")
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date updatedTime;*/

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }
}
