package com.productapp.model.service;

import com.productapp.model.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public Product deleteProduct(int id);
    public Product getById(int id);
}
