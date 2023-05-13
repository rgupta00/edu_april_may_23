package com.productapp.repo;

import com.productapp.entities.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public void addProduct(Product product);
    public void updateProduct(int productId, Product product);
    public Product getById(int productId);
    public void deleteProduct(int productId);
}
