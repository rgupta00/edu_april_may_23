package com.model.service;

import com.model.dto.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class ProductServiceImpl implements ProductService{
    //inject here productDao ....
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        return null;
    }
}
