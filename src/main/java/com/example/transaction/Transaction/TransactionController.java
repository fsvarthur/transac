package com.example.transaction.Transaction;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    private TransactionService transactionService;

    @GetMapping(path = "/")
    private ResponseEntity<String> get(){
        return ResponseEntity.ok("200 OK");
    }

    @PostMapping(path = "/uploadArchive", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<String> postFile(@Valid @RequestPart FilePart filePart){
        String fileName = filePart.filename();
        transactionService.uploadData(filePart);
        return ResponseEntity.ok("Upload file successfull ("+fileName+")");

    }
}
