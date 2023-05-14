package com.productapp.proxy;

import com.productapp.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productservice", url = "http://localhost:8080/products/")
public interface ProductProxy {
    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable int id);
}
