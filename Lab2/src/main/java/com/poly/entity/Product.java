package com.poly.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")  // Thêm dòng này để tắt warning
public class Product {
    private String name;
    private Double price;
}