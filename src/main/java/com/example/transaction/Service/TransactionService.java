package com.example.transaction.Service;

import com.example.transaction.Entity.DTO.TransactionEntityDto;
import com.example.transaction.Entity.TransactionEntity;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionEntity> findById(String id);
    Flux<TransactionEntity> findAll(int page, int size);

    Mono<Void> delete(String id);

    void uploadData(FilePart filePart);
}
