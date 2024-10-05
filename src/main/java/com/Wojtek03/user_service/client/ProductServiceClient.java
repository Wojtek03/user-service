package com.Wojtek03.user_service.client;

import com.Wojtek03.user_service.dto.ProductConfigurationDto;
import com.Wojtek03.user_service.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service", url = "http://product-service:8080")
public interface ProductServiceClient {

    @GetMapping("/api/products")
    ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size);

    @PostMapping("/api/products/{productId}/configurations/{configurationId}")
    ResponseEntity<Void> assignConfigurationToProduct(@PathVariable("productId") Long productId,
                                                      @PathVariable("configurationId") Long configurationId);

    // Configuration Service Endpoints
    @GetMapping("/api/configurations/type/{type}")
    ResponseEntity<List<ProductConfigurationDto>> getConfigurationsByType(@PathVariable("type") String type,
                                                                          @RequestParam(required = false) List<String> allowedValues);
}