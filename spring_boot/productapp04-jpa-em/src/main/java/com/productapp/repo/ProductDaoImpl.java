package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao{

    private EntityManager em;

    @Autowired
    public ProductDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
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
