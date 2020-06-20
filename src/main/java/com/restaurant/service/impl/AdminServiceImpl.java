package com.restaurant.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.commons.Constants;
import com.restaurant.config.DeliveryServicePairingConfig;
import com.restaurant.exceptions.BadRequestException;
import com.restaurant.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);


    private final static ObjectMapper MAPPER=new ObjectMapper();

    //for updating host and port of delivery service application
    @Override
    public void registerDeliveryServiceAddress(String requestBody){
        Map<String, String> requestMap = null;
        try{
            requestMap = MAPPER.convertValue(requestBody,new TypeReference<Map<String, String>>() {});
        }catch (Exception e){
            LOGGER.error("invalid request {}", requestBody);
            LOGGER.error("invalid request", e);
            throw new BadRequestException("bad request");
        }

        if(requestMap != null){
            if(requestMap.get(Constants.HOST_ADDRESS) != null &&
                    requestMap.get(Constants.HOST_NAME) != null &&
                    requestMap.get(Constants.PORT) != null){
                DeliveryServicePairingConfig.setDeliveryServiceHost(requestMap.get(Constants.HOST_ADDRESS));
                DeliveryServicePairingConfig.setDeliveryServicePort(requestMap.get(Constants.PORT));
                return;
            }
        }
        LOGGER.error("invalid request {}", requestBody);
        throw new BadRequestException("invalid request");
    }


}
