package com.productapp;

import javax.annotation.processing.Processor;

public class Mapper {
    public ProductDto mapToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;


    }
}
