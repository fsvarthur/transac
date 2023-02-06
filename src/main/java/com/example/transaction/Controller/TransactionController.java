package com.example.transaction.Controller;

import com.example.transaction.Entity.TransactionEntity;
import com.example.transaction.Exceptions.NotFoundException;
import com.example.transaction.Service.TransactionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(path = "/")
    private ResponseEntity<Flux<TransactionEntity>> get(int page, int size,
                                                        @RequestHeader("Accept-Encoding") String encoding,
                                                        @RequestHeader("Keep-Alive") long keepAlive){
        return ResponseEntity.ok(transactionService.findAll(page, size));
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Mono<TransactionEntity>> getTransactionById(@PathVariable String id){
        return ResponseEntity.ok(transactionService.findById(id).onErrorComplete(NotFoundException.class));
    }

    @PostMapping(path = "/uploadArchive", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<String> importFile(@Valid @RequestPart FilePart filePart){
        String fileName = filePart.filename();
        try{
            transactionService.uploadData(filePart);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("Upload file successfull ("+fileName+")");
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<?> deleteTransaction(@PathVariable String id){
        return ResponseEntity.ok(transactionService.delete(id).onErrorComplete(NotFoundException.class));
    }
}
