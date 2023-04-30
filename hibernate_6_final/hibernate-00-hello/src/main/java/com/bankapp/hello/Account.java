package com.bankapp.hello;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="account_table_hib")
 public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id", nullable = false)
    private Integer id;

    @Column(name = "acc_name", nullable = false, length = 200)
    private String name;

    @Column(name = "acc_balance", nullable = false)
    private BigDecimal balance;

   public Account(String name, BigDecimal balance) {
      this.name = name;
      this.balance = balance;
   }
}
