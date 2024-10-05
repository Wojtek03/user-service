package com.Wojtek03.user_service.controller;

import com.Wojtek03.user_service.dto.*;
import com.Wojtek03.user_service.service.UserProxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserProxyController {

    private final UserProxyService userProxyService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(Pageable pageable) {
        return userProxyService.getAllProducts(pageable);
    }

    @PostMapping("/products/{productId}/configurations/{configurationId}")
    public ResponseEntity<Void> assignConfigurationToProduct(
            @PathVariable Long productId,
            @PathVariable Long configurationId) {
        return userProxyService.assignConfigurationToProduct(productId, configurationId);
    }

    @PostMapping("/carts")
    public CartDto createCart() {
        return userProxyService.createCart();
    }

    @PostMapping("/carts/{cartId}/products/{productId}")
    public CartDto addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return userProxyService.addProductToCart(cartId, productId);
    }

    @GetMapping("/carts/{cartId}/items")
    public List<CartItemDto> getCartItems(@PathVariable Long cartId) {
        return userProxyService.getCartItems(cartId);
    }

    @PostMapping("/orders")
    public OrderDto createOrder(@RequestBody Long cartId) {
        return userProxyService.createOrder(cartId);
    }

    @GetMapping("/orders/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId) {
        return userProxyService.getOrderById(orderId);
    }

    @GetMapping("/configurations/type/{type}")
    public ResponseEntity<List<ProductConfigurationDto>> getConfigurationsByType(
            @PathVariable String type,
            @RequestParam(required = false) List<String> allowedValues) {
        return userProxyService.getConfigurationsByType(type, allowedValues);
    }
}