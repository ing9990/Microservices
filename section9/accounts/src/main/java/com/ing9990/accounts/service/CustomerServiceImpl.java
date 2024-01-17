package com.ing9990.accounts.service;

import com.ing9990.accounts.dto.AccountsDto;
import com.ing9990.accounts.dto.CardsDto;
import com.ing9990.accounts.dto.CustomerDetailsDto;
import com.ing9990.accounts.dto.CustomerDto;
import com.ing9990.accounts.dto.LoansDto;
import com.ing9990.accounts.entity.Accounts;
import com.ing9990.accounts.entity.Customer;
import com.ing9990.accounts.exception.ResourceNotFoundException;
import com.ing9990.accounts.mapper.AccountsMapper;
import com.ing9990.accounts.mapper.CustomerMapper;
import com.ing9990.accounts.repository.AccountsRepository;
import com.ing9990.accounts.repository.CustomerRepository;
import com.ing9990.accounts.service.client.CardsFeignClient;
import com.ing9990.accounts.service.client.LoansFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;


    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
            .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
