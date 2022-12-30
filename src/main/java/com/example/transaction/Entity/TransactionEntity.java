package com.example.transaction.Entity;

import com.example.transaction.User.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "bank_origen", nullable = false)
    private String Bank_Origen;

    @Column(name = "agency_origen", nullable = false)
    private String Agency_Origen;

    @Column(name = "account_origen", nullable = false)
    private String Account_Origen;

    @Column(name = "bank_dest", nullable = false)
    private String Bank_Dest;

    @Column(name = "agency_dest", nullable = false)
    private String Agency_Dest;

    @Column(name = "account_dest", nullable = false)
    private String Account_Dest;

    @Column(name = "amount", nullable = false)
    private String Amount;

    @Column(name = "date_transaction", nullable = false)
    private String Date_Transaction;


    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBank_Origen() {
        return Bank_Origen;
    }

    public void setBank_Origen(String bank_Origen) {
        Bank_Origen = bank_Origen;
    }

    public String getAgency_Origen() {
        return Agency_Origen;
    }

    public void setAgency_Origen(String agency_Origen) {
        Agency_Origen = agency_Origen;
    }

    public String getAccount_Origen() {
        return Account_Origen;
    }

    public void setAccount_Origen(String account_Origen) {
        Account_Origen = account_Origen;
    }

    public String getBank_Dest() {
        return Bank_Dest;
    }

    public void setBank_Dest(String bank_Dest) {
        Bank_Dest = bank_Dest;
    }

    public String getAgency_Dest() {
        return Agency_Dest;
    }

    public void setAgency_Dest(String agency_Dest) {
        Agency_Dest = agency_Dest;
    }

    public String getAccount_Dest() {
        return Account_Dest;
    }

    public void setAccount_Dest(String account_Dest) {
        Account_Dest = account_Dest;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDate_Transaction() {
        return Date_Transaction;
    }

    public void setDate_Transaction(String date_Transaction) {
        Date_Transaction = date_Transaction;
    }
}
