package com.restaurant.dao.impl;

import com.restaurant.commons.SampleData;
import com.restaurant.dao.OrderDetailsDao;
import com.restaurant.model.entity.OrderDetails;
import com.restaurant.model.entity.ProductDetails;
import com.restaurant.request.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    private SampleData sampleData;

    @Autowired
    public OrderDetailsDaoImpl(SampleData sampleData,
                               OrderDetailsDao orderDetailsDao){
        this.sampleData = sampleData;
    }

    @Override
    public void addNewOrder(OrderDetails orderDetails){
        if(orderDetails != null && sampleData.getOrderDetailsMap() != null){
            sampleData.getOrderDetailsMap().put(orderDetails.getOrderId(),orderDetails);
        }
    }

    @Override
    public OrderDetails getOrderById(String orderId){
        if(orderId != null && !orderId.isEmpty() && sampleData.getOrderDetailsMap() != null){
           return sampleData.getOrderDetailsMap().get(orderId);
        }
        return null;
    }

    @Override
    public void updateOrderStatus(String orderId, String status){
        if(status != null){
            if(sampleData.getOrderDetailsMap() != null){
                OrderDetails orderDetails = sampleData.getOrderDetailsMap().get(orderId);
                if(orderDetails != null){
                    orderDetails.setStatus(status);
                }
            }
        }
    }


}
