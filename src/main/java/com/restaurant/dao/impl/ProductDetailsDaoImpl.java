package com.restaurant.dao.impl;


import com.restaurant.commons.SampleData;
import com.restaurant.dao.ProductDetailsDao;
import com.restaurant.model.entity.ProductDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDetailsDaoImpl implements ProductDetailsDao {

    private SampleData sampleData;

    public ProductDetailsDaoImpl(SampleData sampleData){
        this.sampleData = sampleData;
    }
    public List<ProductDetails> getProductsByIds(List<Long> productIds){
        if(sampleData == null){
            return null;
        }

        List<ProductDetails> productList = new ArrayList<>();
        Map<Long,ProductDetails> productDetailsMap = sampleData.getProductDetailsMap();
        for (Long productId : productIds) {
            if(productDetailsMap.get(productId) != null){
                productList.add(productDetailsMap.get(productId));
            }
        }
        return productList;

    }



}
