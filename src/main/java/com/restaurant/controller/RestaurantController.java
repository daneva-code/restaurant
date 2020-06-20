package com.restaurant.controller;

import com.restaurant.Validators.OrderValidator;
import com.restaurant.exceptions.BadRequestException;
import com.restaurant.request.PlaceOrderRequest;
import com.restaurant.request.UpdateOrderStatusRequest;
import com.restaurant.response.CheckStatusResponse;
import com.restaurant.response.PlaceOrderResponse;
import com.restaurant.response.RestResponse;
import com.restaurant.service.RestaurantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final OrderValidator orderValidator;

    RestaurantController(RestaurantService restaurantService,
                         OrderValidator orderValidator){
        this.restaurantService = restaurantService;
        this.orderValidator = orderValidator;
    }


    @RequestMapping(value = "/order/place" , method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PlaceOrderResponse placeOrder(@RequestBody @Valid PlaceOrderRequest requestBody) throws BadRequestException {
        orderValidator.validateNewOrderRequest(requestBody);
        return restaurantService.placeNewOrder(requestBody);
    }

    @RequestMapping(value = "/order/status" , method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CheckStatusResponse checkOrderStatus(@RequestParam(value = "orderId") String orderId) {
        return restaurantService.getOrderStatus(orderId);
    }

    @RequestMapping(value = "/order/status" , method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RestResponse updateOrderStatus(@RequestBody @Valid UpdateOrderStatusRequest requestBody) {
        if(!orderValidator.isOrderStatusValid(requestBody.getStatus())){
            throw new BadRequestException("invalid status");
        }
        if(!orderValidator.isOrderValid(requestBody.getOrderId())){
            throw new BadRequestException("invalid order id");
        }

        restaurantService.updateOrderStatus(requestBody);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message","updated");
        return new RestResponse(200,responseBody,null);
    }




}
