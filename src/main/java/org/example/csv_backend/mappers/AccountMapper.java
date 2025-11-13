package org.example.csv_backend.mappers;
import org.example.csv_backend.dtos.AccountDto;
import org.example.csv_backend.dtos.AccountResponseDto;
import org.example.csv_backend.entities.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account dtoToAccount(AccountDto dto);
    AccountResponseDto accountToResponseDto(Account account);
    List<Account> dtosToAccounts(List<AccountDto> dtos);
    List<AccountResponseDto> accountsToResponseDtos(List<Account> accounts);
}
