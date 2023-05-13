package com.productapp.model.service;

import com.productapp.model.dao.ProductDao;
import com.productapp.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional //Spring use AOP to mangage the tx in declartive way !
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
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productDao.updateProduct(id, product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }
}
