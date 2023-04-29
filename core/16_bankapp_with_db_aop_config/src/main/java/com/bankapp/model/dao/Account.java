package com.bankapp.model.dao;

import lombok.*;

import java.math.BigDecimal;
//DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private int id;
    private String name;
    private BigDecimal balance;


}
