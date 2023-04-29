package com.model.service;

import com.model.dto.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product getById(Integer id );
    public Product addProduct(Product product);
    public Product deleteProduct(Integer id );
    public Product updateProduct(Integer id, Product product );
}
