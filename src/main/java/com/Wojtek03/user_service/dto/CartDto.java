package com.Wojtek03.user_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private Long id;
    private List<CartItemDto> items;
}
