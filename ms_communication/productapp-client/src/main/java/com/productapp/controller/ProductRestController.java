package com.productapp.controller;

import com.productapp.dto.Product;
import com.productapp.proxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductRestController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductProxy productProxy;

    @GetMapping(path = "productsclient/{id}")
    public Product getProductFromClient(@PathVariable int id){

//        Product productFromClient=restTemplate
//                .getForObject("http://localhost:8080/products/"+id,Product.class);

        return productProxy.getProductById(id);
    }
}
