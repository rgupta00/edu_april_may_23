package com.productapp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private  int id;
    private String name;
    private double price;


}
