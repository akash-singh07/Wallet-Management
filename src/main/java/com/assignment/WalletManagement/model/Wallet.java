package com.assignment.WalletManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wallet")

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long walletId;

    @Column(name = "mobile_no", nullable = false, length = 10)
    private String mobileNumber;

    @Column(name = "balance")
    private float currentBalance;
}
