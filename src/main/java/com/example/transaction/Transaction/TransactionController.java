package com.example.transaction.Transaction;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping(path = "/uploadArchive", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<String> postFile(@Valid @RequestPart FilePart filePart){
        String fileName = filePart.filename();
        transactionService.uploadData(filePart);
        return ResponseEntity.ok("Upload file successfull ("+fileName+")");

    }
}
