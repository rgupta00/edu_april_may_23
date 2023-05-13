package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(int productId, Product product) {

    }

    @Override
    public Product getById(int productId) {
        return null;
    }

    @Override
    public void deleteProduct(int productId) {

    }
}
