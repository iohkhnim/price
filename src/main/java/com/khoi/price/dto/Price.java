package com.khoi.price.dto;

import com.khoi.basecrud.dto.baseDTO;
import com.khoi.proto.CreateRequest;
import com.khoi.proto.PriceEntry;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  private String convertDate2String(Date date){
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    return dateFormat.format(date);
  }

  public static Price fromProto(PriceEntry proto) {
    Price price = new Price();
    price.setId(proto.getId());
    price.setPrice(proto.getPrice());
    price.setProduct_id(proto.getProductId());
    price.setCreatedTime(new Date(proto.getCreatedTime()));
    price.setUpdatedTime(new Date(proto.getUpdatedTime()));
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
        .setPrice(getPrice()).setCreatedTime(convertDate2String(getCreatedTime()))
        .setUpdatedTime(convertDate2String(getUpdatedTime())).build();
  }

}
