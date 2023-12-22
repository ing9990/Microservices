package com.ing9990.accounts.controller;

import static com.ing9990.accounts.constants.AccountsConstants.MESSAGE_201;
import static com.ing9990.accounts.constants.AccountsConstants.STATUS_201;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.ing9990.accounts.constants.AccountsConstants;
import com.ing9990.accounts.dto.CustomerDto;
import com.ing9990.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {APPLICATION_JSON_VALUE})
public class AccountsController {

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        return ResponseEntity
            .status(CREATED)
            .body(new ResponseDto(STATUS_201, MESSAGE_201));
    }

}
