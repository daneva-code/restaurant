package com.restaurant.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DeliveryServicePairingConfig {

    private static String deliveryServiceHost;

    private static String deliveryServicePort;


    public static String getDeliveryServiceHost() {
        return deliveryServiceHost;
    }

    public static void setDeliveryServiceHost(String deliveryServiceHost) {
        DeliveryServicePairingConfig.deliveryServiceHost = deliveryServiceHost;
    }

    public static String getDeliveryServicePort() {
        return deliveryServicePort;
    }

    public static void setDeliveryServicePort(String deliveryServicePort) {
        DeliveryServicePairingConfig.deliveryServicePort = deliveryServicePort;
    }
}
