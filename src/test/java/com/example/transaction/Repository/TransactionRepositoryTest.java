package com.example.transaction.Repository;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
class TransactionRepositoryTest {
    @Autowired
    TransactionRepository transactionRepository;

    @Test
    void readAllEntitiesCorrectly(){
        transactionRepository.findAll()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void readEntitiesByNameCorrectly(){
        transactionRepository.findByTransactionId(1L)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

    }

}