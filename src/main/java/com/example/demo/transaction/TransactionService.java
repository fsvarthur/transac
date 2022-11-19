package com.example.demo.transaction;

import org.springframework.data.domain.Page;
import org.springframework.http.codec.multipart.FilePart;

public interface TransactionService {

    TransactionEntity create(TransactionEntity transactionEntity);
    TransactionEntity findById(String id);
    Page<TransactionEntity> findAll(int page, int size);
    TransactionEntity update(String id, TransactionEntity request);
    boolean delete(String id);

    void uploadData(FilePart filePart);
}
