package com.bankapp.model.repo;

import com.bankapp.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// wow we are declaring dao layer
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
}
