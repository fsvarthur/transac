package com.example.transaction.Controller;

import com.example.transaction.Service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);
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
