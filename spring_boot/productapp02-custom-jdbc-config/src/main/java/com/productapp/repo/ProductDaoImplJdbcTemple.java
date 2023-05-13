package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;
import java.util.List;
@Repository
public class ProductDaoImplJdbcTemple implements ProductDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImplJdbcTemple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("select * from product_table_new",
                new ProductRowMapper());
    }

    @Override
    public void addProduct(Product product) {
    //
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
