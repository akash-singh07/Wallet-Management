package com.assignment.WalletManagement.repository;

import com.assignment.WalletManagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value="SELECT * FROM transaction WHERE sender = ?1 OR receiver = ?1", nativeQuery = true)
    List<Transaction> findByMobileNumber(String mobileNumber);
}
