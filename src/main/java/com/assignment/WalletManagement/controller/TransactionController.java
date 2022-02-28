package com.assignment.WalletManagement.controller;

import com.assignment.WalletManagement.model.Transaction;
import com.assignment.WalletManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public String transferMoney(@RequestBody Transaction transaction) {
        return transactionService.transferMoney(transaction);
    }

    @GetMapping("/transaction/user/{id}")
    public List<Transaction> getTransactionSummary(@PathVariable Long id) throws Exception {
        return transactionService.getTransactionSummary(id);
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionStatus(@PathVariable Long id) throws Exception {
        return transactionService.getTransactionStatus(id);
    }
}
