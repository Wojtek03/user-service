package com.Wojtek03.user_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductConfigurationDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String value;
    private String type;
}
