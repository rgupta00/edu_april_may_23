package com.bankapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account_table_hib")
public  class Account{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id", nullable = false)
    private int id;

    @Column(name = "acc_name", nullable = false, length = 200)
    private String name;

    @Column(name = "acc_balance", nullable = false)
    private BigDecimal balance;

}
