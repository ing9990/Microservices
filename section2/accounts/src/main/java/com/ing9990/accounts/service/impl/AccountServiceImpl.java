package com.ing9990.accounts.service.impl;

import com.ing9990.accounts.dto.CustomerDto;
import com.ing9990.accounts.repository.AccountsRepository;
import com.ing9990.accounts.repository.CustomerRepository;
import com.ing9990.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
