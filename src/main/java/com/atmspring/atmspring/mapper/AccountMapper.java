package com.atmspring.atmspring.mapper;

import com.atmspring.atmspring.dto.AccountDTO;
import com.atmspring.atmspring.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {UserMapper.class, TransactionMapper.class})
public interface AccountMapper extends GenericMapper<Account, AccountDTO> {

}
