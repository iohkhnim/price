package com.khoi.price.dto;

import com.khoi.basecrud.dto.baseDTO;
import com.khoi.proto.CreateRequest;
import com.khoi.proto.PriceEntry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price extends baseDTO implements Serializable {

  @Column(name = "product_id")
  private int product_id;

  @Column(name = "price")
  private int price;

  public static Price fromProto(PriceEntry proto) {
    Price price = new Price();
    price.setPrice(proto.getPrice());
    price.setProduct_id(proto.getProductId());
    return price;
  }

  public static Price fromProto(CreateRequest proto) {
    Price price = new Price();
    price.setPrice(proto.getPrice());
    price.setProduct_id(proto.getProductId());
    return price;
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public PriceEntry toProto() {
    return PriceEntry.newBuilder().setId(getId()).setProductId(getProduct_id())
        .setPrice(getPrice()).setCreatedTime(getCreatedTime().getTime())
        .setUpdatedTime(getUpdatedTime().getTime()).build();
  }

}
