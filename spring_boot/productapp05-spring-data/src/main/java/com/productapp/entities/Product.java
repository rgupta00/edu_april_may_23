package com.productapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product_table_new2")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{product.name.absent}")
    @Column(nullable = false, length = 40)
    private String name;

    @NotNull(message = "price can not be null")
    @Min(value = 10, message =  "min price should be more then 10")
    @Max(value = 1000000, message =  "min price should be more then 1000000")
    private BigDecimal price;
}
