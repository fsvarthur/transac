package com.example.transaction.Config;

import com.example.transaction.Entity.DTO.TransactionEntityDto;
import com.example.transaction.Entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    TransactionEntity apiToEntity(TransactionEntityDto ted);
}
