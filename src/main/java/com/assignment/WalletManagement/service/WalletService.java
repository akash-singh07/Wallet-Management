package com.assignment.WalletManagement.service;

import com.assignment.WalletManagement.model.Transaction;
import com.assignment.WalletManagement.model.Wallet;
import com.assignment.WalletManagement.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public String createWallet(Wallet wallet) {
        if (walletRepository.findByMobileNumber(wallet.getMobileNumber()) != null)
            throw new RuntimeException("Wallet with given Mobile Number already exists.");
        walletRepository.save(wallet);
        return "Wallet created successfully.";
    }

}
