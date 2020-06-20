package com.restaurant.service;

import com.restaurant.request.PlaceOrderRequest;
import com.restaurant.request.UpdateOrderStatusRequest;
import com.restaurant.response.CheckStatusResponse;
import com.restaurant.response.PlaceOrderResponse;

public interface RestaurantService {

    PlaceOrderResponse placeNewOrder(PlaceOrderRequest requestBody);
    CheckStatusResponse getOrderStatus(String orderId);
    void updateOrderStatus(UpdateOrderStatusRequest requestBody);
}
