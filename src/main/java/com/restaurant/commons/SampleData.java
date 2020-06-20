package com.restaurant.commons;

import com.restaurant.model.entity.OrderDetails;
import com.restaurant.model.entity.ProductDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class SampleData {

    private static Map<Long, ProductDetails> productDetailsMap;
    private static Map<String, OrderDetails> orderDetailsMap;

    static {
        productDetailsMap = new HashMap<>();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(1L);
        productDetails.setStatus("ACTIVE");
        productDetails.setProductName("Samosa");
        productDetails.setDescription("It is made with mashed potatoes");
        productDetailsMap.put(productDetails.getId(), productDetails);
    }

    public static Map<Long, ProductDetails> getProductDetailsMap() {
        return productDetailsMap;
    }

    public static Map<String, OrderDetails> getOrderDetailsMap() {
        return orderDetailsMap;
    }


}
