package com.poly.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab7Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab7Application.class, args);
    }
}

// http://localhost:8080/product/search
// http://localhost:8080/product/search-and-page
// http://localhost:8080/report/inventory-by-category