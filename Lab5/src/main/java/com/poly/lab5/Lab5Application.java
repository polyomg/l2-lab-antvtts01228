package com.poly.lab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab5Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }
}

//http://localhost:8080/account/login  Đăng nhập ( poly/ 123)
//
//http://localhost:8080/item/index  Xem danh sách sản phẩm và thêm vào giỏ hàng
//
//http://localhost:8080/cart/view  Xem giỏ hàng