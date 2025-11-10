package org.example.csv_backend.mappers;

import org.example.csv_backend.dtos.AccountDto;
import org.example.csv_backend.entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto accountToDto(Account account);
    Account dtoToAccount(AccountDto accountDto);
    AccountDto[] accountsToDtos(Account[] accounts);
    Account[] dtosToAccounts(AccountDto[] accountDtos);
}
