package com.example.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.domain.Page;
import org.springframework.http.codec.multipart.FilePart;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionEntity create(TransactionEntity transactionEntity) {
        return null;
    }

    @Override
    public TransactionEntity findById(String id) {
        return null;
    }

    @Override
    public Page<TransactionEntity> findAll(int page, int size) {
        return null;
    }

    @Override
    public TransactionEntity update(String id, TransactionEntity request) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void uploadData(FilePart filePart) {
        String REGEX_CSV_SPLIT = ",(?=([^\"])*[^\"]*$)";
        filePart.content()
                .map(DataBuffer::asInputStream)
                .map( inputStream -> {
                    try{
                        return inputStream.readAllBytes();
                    }catch(IOException io){
                        throw  new RuntimeException(io);
                    }
                })
                .map(String::new)
                .flatMapIterable(data ->{
                    List<String> strings = Arrays.stream(data.split("\n")).collect(Collectors.toList());
                    String header = strings.remove(0);
                    return strings;
                })
                .map( data-> data.trim().split(REGEX_CSV_SPLIT))
                .doOnNext(columns -> {
                    String Bank_Origen = columns[0];
                    String Agency_Origen = columns[1];
                    String Account_Origen = columns[2];
                    String Bank_Dest = columns[3];
                    String Agency_Dest = columns[4];
                    String Account_Dest = columns[5];
                    String Amount = columns[6];
                    String Date_Transaction = columns[7];
                    try {
                        TransactionEntity transactionEntity = new TransactionEntity(Bank_Origen, Agency_Origen,
                                Account_Origen, Bank_Dest, Agency_Dest, Account_Dest, Amount, Date_Transaction);
                        create(transactionEntity);
                    }catch (RuntimeException e){
                        throw new RuntimeException(e);
                    }
                })
                .subscribe();
    }
}
