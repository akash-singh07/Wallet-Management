package com.assignment.WalletManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long transactionId;

    @Column(name = "sender")
    private String payerMobileNumber;

    @Column(name = "receiver")
    private String payeeMobileNumber;

    @Column(name = "amount")
    private float amount;

}
