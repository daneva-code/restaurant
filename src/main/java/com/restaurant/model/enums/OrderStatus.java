package com.restaurant.model.enums;

import java.util.HashSet;
import java.util.Set;

public enum OrderStatus {

    PLACED ("PLACED"),
    PICKED_FOR_DELIVERY("PICKED_FOR_DELIVERY"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    FAILED  ("FAILED");

    private String value;

    private static Set<String> orderStatusSet;

    static {
        orderStatusSet = new HashSet<>();
        orderStatusSet.add("PLACED");
        orderStatusSet.add("PICKED_FOR_DELIVERY");
        orderStatusSet.add("DELIVERING");
        orderStatusSet.add("DELIVERED");
        orderStatusSet.add("FAILED");
    }

    OrderStatus(String value){
        this.value=value;
    }

    public String getValue() {
        return this.value;
    }

    public static Set<String> getOrderStatusSet() {
        return orderStatusSet;
    }

}
