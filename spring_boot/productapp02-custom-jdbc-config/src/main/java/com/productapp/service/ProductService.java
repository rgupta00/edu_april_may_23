package com.productapp.service;

import com.productapp.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public void addProduct(Product product);
    public void updateProduct(int productId, Product product);
    public Product getById(int productId);
    public void deleteProduct(int productId);
}
