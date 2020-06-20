package com.restaurant.controller;


import com.restaurant.exceptions.BadRequestException;
import com.restaurant.response.RestResponse;
import com.restaurant.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    private final AdminService adminService;

    @Autowired
    AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @RequestMapping(value = "/register/deliveryService" , method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RestResponse registerDeliveryServiceAddress(@RequestBody String requestBody) throws BadRequestException {
        adminService.registerDeliveryServiceAddress(requestBody);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message","updated");
        return new RestResponse(200,responseBody,null);

    }
}
