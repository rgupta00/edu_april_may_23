package com.bankapp.model.dao;

import lombok.*;

import java.math.BigDecimal;
//DTO
//POJO : plan old java object : simple java object : basic coding convension

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account{
    private int id;
    private String name;
    private BigDecimal balance;


}
