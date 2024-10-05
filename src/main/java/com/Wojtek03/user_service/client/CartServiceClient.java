package com.Wojtek03.user_service.client;

import com.Wojtek03.user_service.dto.CartDto;
import com.Wojtek03.user_service.dto.CartItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cart-service", url = "http://cart-service:8082")
public interface CartServiceClient {

    @PostMapping
    CartDto createCart();

    @PostMapping("/{cartId}/products/{productId}")
    CartDto addProductToCart(@PathVariable("cartId") Long cartId,
                             @PathVariable("productId") Long productId);

    @GetMapping("/{cartId}/items")
    List<CartItemDto> getCartItems(@PathVariable("cartId") Long cartId);
}

