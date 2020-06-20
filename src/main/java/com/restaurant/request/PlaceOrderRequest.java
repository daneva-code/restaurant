package com.restaurant.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurant.model.OrderItemDetail;

import javax.validation.constraints.NotBlank;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceOrderRequest {

    @NotBlank(message = "Field can not be null or empty")
    private List<OrderItemDetail> orderItems;

    @NotBlank(message = "Field can not be null or empty")
    private String customerName;

    @NotBlank(message = "Field can not be null or empty")
    private String deliveryAddress;

    @NotBlank(message = "Field can not be null or empty")
    private String customerContact;

    @NotBlank(message = "Field can not be null or empty")
    private Long orderPrice;

    public List<OrderItemDetail> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDetail> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public Long getOrderPrice() { return orderPrice; }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }
}
