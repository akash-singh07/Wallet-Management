package com.assignment.WalletManagement.service;

import com.assignment.WalletManagement.model.Transaction;
import com.assignment.WalletManagement.model.Wallet;
import com.assignment.WalletManagement.repository.TransactionRepository;
import com.assignment.WalletManagement.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String transferMoney(Transaction transaction) {

        Wallet payer = walletRepository.findByMobileNumber(transaction.getPayerMobileNumber());
        Wallet payee = walletRepository.findByMobileNumber(transaction.getPayeeMobileNumber());

        if (payer == null)
            throw new RuntimeException("Wallet linked with payer mobile number does not exist.");
        if (payee == null)
            throw new RuntimeException("Wallet linked with payee mobile number does not exist.");

        if (payer.getCurrentBalance() < transaction.getAmount())
            throw new RuntimeException("Sorry, Insufficient Balance.");

        payer.setCurrentBalance(payer.getCurrentBalance() - transaction.getAmount());
        payee.setCurrentBalance(payee.getCurrentBalance() + transaction.getAmount());

        walletRepository.save(payer);
        walletRepository.save(payee);

        transactionRepository.save(transaction);

        return "Transaction successful.";

    }

    public List<Transaction> getTransactionSummary(Long userId) throws Exception {
        Wallet wallet = walletRepository.findById(userId).orElseThrow(() -> new Exception("UserId does not exist"));
        return transactionRepository.findByMobileNumber(wallet.getMobileNumber());
    }

    public Transaction getTransactionStatus(Long transactionId) throws Exception {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new Exception("Transaction not found."));
        return transaction;
    }
}
