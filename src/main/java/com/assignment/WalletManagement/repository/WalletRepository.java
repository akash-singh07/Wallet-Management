package com.assignment.WalletManagement.repository;

import com.assignment.WalletManagement.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Wallet findByMobileNumber(String mobileNumber);

}
