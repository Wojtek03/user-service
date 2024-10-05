package com.Wojtek03.user_service.client;

import com.Wojtek03.user_service.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://order-service:8083")
public interface OrderServiceClient {

    @PostMapping("/create/{cartId}")
    OrderDto createOrder(@PathVariable("cartId") Long cartId);

    @GetMapping("/{orderId}")
    OrderDto getOrderById(@PathVariable("orderId") Long orderId);
}
