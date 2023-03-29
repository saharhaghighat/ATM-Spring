package com.atmspring.atmspring.mapper;

import com.atmspring.atmspring.dto.TransactionDTO;
import com.atmspring.atmspring.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<Transaction, TransactionDTO> {
}
