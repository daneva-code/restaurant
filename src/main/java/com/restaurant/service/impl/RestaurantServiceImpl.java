package com.restaurant.service.impl;

import com.restaurant.dao.OrderDetailsDao;
import com.restaurant.dao.ProductDetailsDao;
import com.restaurant.exceptions.ResourceNotFoundException;
import com.restaurant.model.entity.OrderDetails;
import com.restaurant.model.enums.OrderStatus;
import com.restaurant.request.PlaceOrderRequest;
import com.restaurant.request.UpdateOrderStatusRequest;
import com.restaurant.response.CheckStatusResponse;
import com.restaurant.response.PlaceOrderResponse;
import com.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final OrderDetailsDao orderDetailsDao;

    private final ProductDetailsDao productDetailsDao;

    @Autowired
    public RestaurantServiceImpl(OrderDetailsDao orderDetailsDao,
                                 ProductDetailsDao productDetailsDao){
        this.orderDetailsDao = orderDetailsDao;
        this.productDetailsDao = productDetailsDao;
    }

    //adds new order in SampleData
    @Override
    public PlaceOrderResponse placeNewOrder(PlaceOrderRequest requestBody){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(UUID.randomUUID().toString());
        orderDetails.setPrice(requestBody.getOrderPrice());
        orderDetails.setStatus(OrderStatus.PLACED.getValue());
        orderDetails.setCustomerContact(requestBody.getCustomerContact());
        orderDetails.setOrderDeliveryAddress(requestBody.getDeliveryAddress());
        orderDetails.setCustomerName(requestBody.getCustomerName());
        orderDetails.setOrderItemData(requestBody.getOrderItems().toString());
        try{
            orderDetailsDao.addNewOrder(orderDetails);
        }catch (Exception e){
            LOGGER.error("error in creating new order for order details {}",orderDetails);
            LOGGER.error("error in creating new order",e);
            return new PlaceOrderResponse(OrderStatus.FAILED.getValue());
        }
        return new PlaceOrderResponse(orderDetails.getOrderId(), OrderStatus.PLACED.getValue());
    }

    @Override
    public CheckStatusResponse getOrderStatus(String orderId){
        OrderDetails orderDetails = orderDetailsDao.getOrderById(orderId);
        if(orderDetails == null){
            throw new ResourceNotFoundException("order not found");
        }
        return new CheckStatusResponse(orderDetails.getStatus());
    }

    @Override
    public void updateOrderStatus(UpdateOrderStatusRequest requestBody){
        orderDetailsDao.updateOrderStatus(requestBody.getOrderId(), requestBody.getStatus());
    }
}
