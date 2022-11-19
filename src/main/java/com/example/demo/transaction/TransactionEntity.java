package com.example.demo.transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank
    @NotNull
    private String Date_Transaction;

    public TransactionEntity() {
    }


}
