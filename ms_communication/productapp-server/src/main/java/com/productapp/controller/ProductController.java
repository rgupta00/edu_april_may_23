package com.productapp.controller;

import com.productapp.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(path = "products/{id}")
    public Product getProductById(@PathVariable int id){
        return new Product(id, "laptop ", 90000);
    }
}
