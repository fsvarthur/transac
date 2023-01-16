package com.example.transaction.Entity;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link TransactionEntity} entity
 */
@Data
public class TransactionEntityDto implements Serializable {
    private final Long Id;
    private final String Bank_Origen;
    private final String Agency_Origen;
    private final String Account_Origen;
    private final String Bank_Dest;
    private final String Agency_Dest;
    private final String Account_Dest;
    private final String Amount;
    private final String Date_Transaction;
}