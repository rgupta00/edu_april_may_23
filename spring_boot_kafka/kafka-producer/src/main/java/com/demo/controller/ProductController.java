package com.demo.controller;

import com.demo.dto.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("producer")
    public String callProducer( @RequestBody Product product){
        productService.produce(product);
        return "message is send to kafka server";
    }

}
