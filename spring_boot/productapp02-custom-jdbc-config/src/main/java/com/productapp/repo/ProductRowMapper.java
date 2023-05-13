package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product
                =Product.builder()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .price(rs.getBigDecimal(3))
                .build();

        return product;
    }
}
