package com.restaurant.dao;

import com.restaurant.model.entity.ProductDetails;

import java.util.List;

public interface ProductDetailsDao {

    List<ProductDetails> getProductsByIds(List<Long> productIds);
}
