package com.poly.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab6Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }
}
//http://localhost:8080/category/index → CRUD Loại hàng
//
//http://localhost:8080/product/sort → Sắp xếp
//
//http://localhost:8080/product/page → Phân trang