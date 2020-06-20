package com.restaurant.model.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "order_id")
  private String orderId;

  @Column(name = "price")
  private Long price;

  @Column(name = "order_delivery_address")
  private String orderDeliveryAddress;

  @Column(name = "order_item_data")
  private String orderItemData;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "customer_contact")
  private String customerContact;

  @Column(name = "status")
  private String status;

  @Column(name = "created_at", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Column(name="updated_at",columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public String getOrderDeliveryAddress() {
    return orderDeliveryAddress;
  }

  public void setOrderDeliveryAddress(String orderDeliveryAddress) {
    this.orderDeliveryAddress = orderDeliveryAddress;
  }

  public String getOrderItemData() {
    return orderItemData;
  }

  public void setOrderItemData(String orderItemData) {
    this.orderItemData = orderItemData;
  }

  public String getCustomerContact() {
    return customerContact;
  }

  public void setCustomerContact(String customerContact) {
    this.customerContact = customerContact;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
