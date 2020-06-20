package com.restaurant.response;

public class PlaceOrderResponse {

    private String orderId;
    private String orderStatus;

    public PlaceOrderResponse(String orderId, String orderStatus){
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public PlaceOrderResponse(String orderStatus){
        this.orderStatus = orderStatus;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
