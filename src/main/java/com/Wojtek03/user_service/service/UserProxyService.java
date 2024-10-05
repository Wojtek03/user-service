package com.Wojtek03.user_service.service;

import com.Wojtek03.user_service.client.CartServiceClient;
import com.Wojtek03.user_service.client.OrderServiceClient;
import com.Wojtek03.user_service.client.ProductServiceClient;
import com.Wojtek03.user_service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProxyService {

    private final ProductServiceClient productServiceClient;
    private final CartServiceClient cartServiceClient;
    private final OrderServiceClient orderServiceClient;

    // Product Service Methods
    public ResponseEntity<List<ProductDto>> getAllProducts(Pageable pageable) {
        return productServiceClient.getAllProducts(pageable.getPageNumber(), pageable.getPageSize());
    }

    public ResponseEntity<Void> assignConfigurationToProduct(Long productId, Long configurationId) {
        return productServiceClient.assignConfigurationToProduct(productId, configurationId);
    }

    public ResponseEntity<List<ProductConfigurationDto>> getConfigurationsByType(String type, List<String> allowedValues) {
        return productServiceClient.getConfigurationsByType(type, allowedValues);
    }

    public CartDto createCart() {
        return cartServiceClient.createCart();
    }

    public CartDto addProductToCart(Long cartId, Long productId) {
        return cartServiceClient.addProductToCart(cartId, productId);
    }

    public List<CartItemDto> getCartItems(Long cartId) {
        return cartServiceClient.getCartItems(cartId);
    }

    // Order Service Methods
    public OrderDto createOrder(Long cartId) {
        return orderServiceClient.createOrder(cartId);
    }

    public OrderDto getOrderById(Long orderId) {
        return orderServiceClient.getOrderById(orderId);
    }
}