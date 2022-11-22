package com.example.transaction.Transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String Bank_Origen;
    private String Agency_Origen;
    private String Account_Origen;
    private String Bank_Dest;
    private String Agency_Dest;
    private String Account_Dest;
    private String Amount;
    private String Date_Transaction;

    public TransactionEntity() {
    }

    public TransactionEntity(String bank_Origen, String agency_Origen, String account_Origen, String bank_Dest, String agency_Dest, String account_Dest, String amount, String date_Transaction) {
        Bank_Origen = bank_Origen;
        Agency_Origen = agency_Origen;
        Account_Origen = account_Origen;
        Bank_Dest = bank_Dest;
        Agency_Dest = agency_Dest;
        Account_Dest = account_Dest;
        Amount = amount;
        Date_Transaction = date_Transaction;
    }
}
