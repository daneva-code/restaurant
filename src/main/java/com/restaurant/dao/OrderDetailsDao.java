package com.restaurant.dao;

import com.restaurant.model.entity.OrderDetails;
import com.restaurant.request.PlaceOrderRequest;

public interface OrderDetailsDao {

    void addNewOrder(OrderDetails orderDetails);
    OrderDetails getOrderById(String orderId);
    void updateOrderStatus(String orderId, String status);

}
