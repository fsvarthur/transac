package com.example.transaction.Repository;

import com.example.transaction.Entity.TransactionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TransactionRepository extends ReactiveCrudRepository<TransactionEntity, Long> {
    Mono<TransactionEntity> findByTransactionId(Long id);
}
