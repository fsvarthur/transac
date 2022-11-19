package com.example.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<String> postFile(@RequestPart FilePart filePart){
        String fileName = filePart.filename();
        transactionService.uploadData(filePart);
        return ResponseEntity.ok("Upload file successfull ("+fileName+")");
    }
}
