package org.example.csv_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.csv_backend.mappers.AccountMapper;
import org.example.csv_backend.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;




}
