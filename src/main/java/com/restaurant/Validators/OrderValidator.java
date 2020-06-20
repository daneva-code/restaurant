package com.restaurant.Validators;

import com.restaurant.dao.OrderDetailsDao;
import com.restaurant.dao.ProductDetailsDao;
import com.restaurant.model.OrderItemDetail;
import com.restaurant.model.entity.OrderDetails;
import com.restaurant.model.entity.ProductDetails;
import com.restaurant.model.enums.OrderStatus;
import com.restaurant.request.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderValidator {

    private final ProductDetailsDao productDetailsDao;

    private final OrderDetailsDao orderDetailsDao;

    @Autowired
    public OrderValidator(ProductDetailsDao productDetailsDao,
                          OrderDetailsDao orderDetailsDao) {
        this.productDetailsDao = productDetailsDao;
        this.orderDetailsDao = orderDetailsDao;
    }


    public boolean validateNewOrderRequest(PlaceOrderRequest request) {
        return checkItemAvailability(request.getOrderItems());
        //validate other things
    }

    public boolean isOrderStatusValid(String status) {
        return OrderStatus.getOrderStatusSet().contains(status);
    }

    public boolean isOrderValid(String orderId) {
        return orderDetailsDao.getOrderById(orderId) != null;
    }

    //checks if order items available in product list
    private boolean checkItemAvailability(List<OrderItemDetail> items) {
        List<Long> productIds = items.stream().map(item -> item.getItemId()).collect(Collectors.toList());
        List<ProductDetails> productDetailsList = productDetailsDao.getProductsByIds(productIds);
        return (productDetailsList != null && productDetailsList.size() == productIds.size()) ? true : false;
    }


}
