package com.restaurant.response;

public class CheckStatusResponse {

    private String orderStatus;

    public CheckStatusResponse(){};

    public CheckStatusResponse(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
