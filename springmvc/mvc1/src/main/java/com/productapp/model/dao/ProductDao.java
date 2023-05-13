package com.productapp.model.dao;

import com.productapp.model.entities.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public Product deleteProduct(int id);
    public Product getById(int id);
}
