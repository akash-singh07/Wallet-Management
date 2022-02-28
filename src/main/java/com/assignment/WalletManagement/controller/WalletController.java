package com.assignment.WalletManagement.controller;

import com.assignment.WalletManagement.model.Transaction;
import com.assignment.WalletManagement.model.Wallet;
import com.assignment.WalletManagement.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/get")
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @PostMapping("/wallet")
    public String createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

}
