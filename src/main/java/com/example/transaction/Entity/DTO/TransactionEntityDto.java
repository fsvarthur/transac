package com.example.transaction.Entity.DTO;

import com.example.transaction.Entity.TransactionEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link TransactionEntity} entity
 */
@Data
public class TransactionEntityDto implements Serializable {
    private Long Id;
    private String Bank_Origen;
    private String Agency_Origen;
    private String Account_Origen;
    private String Bank_Dest;
    private String Agency_Dest;
    private String Account_Dest;
    private String Amount;
    private String Date_Transaction;

    public TransactionEntityDto(long l, String bankOrigen, String agencyOrigen, String accountOrigen, String bankDest, String agencyDest, String accountDest, String amount, String dateTransaction) {
    }
}