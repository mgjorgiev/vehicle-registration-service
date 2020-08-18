package com.vehicle.service.implementation;

import com.vehicle.domain.entity.Account;
import com.vehicle.domain.repository.AccountRepository;
import com.vehicle.dto.response.AccountResponse;
import com.vehicle.service.AccountService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse addNewAccount(String accountId) {
        Optional<Account> existingAccouint = this.accountRepository.findAccountByUsername(accountId);
        AccountResponse accountResponse = new AccountResponse();
        if (existingAccouint.isPresent()) {
            accountResponse.setDescription("Provided account ID already exists.");
            return accountResponse;
        }
        String password = populateAndSaveAccount(accountId);

        accountResponse.setDescription("Your account has been successfully opened.");
        accountResponse.setSuccess(true);
        accountResponse.setPassword(password);

        return accountResponse;
    }

    private String populateAndSaveAccount(String accountId) {
        Account account = new Account();
        account.setUsername(accountId);
        String password = RandomStringUtils.random(8, true, true);
        account.setPassword(password);
        this.accountRepository.save(account);
        return password;
    }

}
