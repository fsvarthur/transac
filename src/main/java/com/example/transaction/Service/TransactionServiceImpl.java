package com.example.transaction.Service;


import com.example.transaction.Config.TransactionMapper;
import com.example.transaction.Entity.DTO.TransactionEntityDto;
import com.example.transaction.Entity.TransactionEntity;
import com.example.transaction.Repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.logging.Level.FINE;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final TransactionMapper mapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper mapper) {
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono<TransactionEntity> Create(TransactionEntityDto TED) {
        return transactionRepository.save(mapper.apiToEntity(TED));
    }

    @Override
    public Mono<TransactionEntity> findById(String id) {
        return transactionRepository.findByTransactionId(Long.valueOf(id));
    }

    @Override
    public Flux<TransactionEntity> findAll(int page, int size) {
        return transactionRepository.findAll().log(LOG.getName(), FINE).map(e -> e);
    }

    @Override
    public Mono<Void> delete(String id){
        return transactionRepository.findByTransactionId(Long.valueOf(id)).log(LOG.getName(), FINE).map(
                e -> transactionRepository.delete(e)).flatMap(e -> e);
    }

    @Override
    public void uploadData(FilePart filePart) {
        String REGEX_CSV_SPLIT = ",(?=([^\"])*[^\"]*$)";
        filePart.content()
                .map(DataBuffer::asInputStream)
                .map(inputStream -> {
                    try{
                        return inputStream.readAllBytes();
                    }catch(IOException io){
                        throw new RuntimeException(io);
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
                    TransactionEntityDto transactionEntity = new TransactionEntityDto(1L,Bank_Origen, Agency_Origen,
                            Account_Origen, Bank_Dest, Agency_Dest, Account_Dest, Amount, Date_Transaction);
                    Create(transactionEntity);
                })
                .subscribe();
    }

}
