package com.Wojtek03.user_service.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long cartId;
    private String status;
}
