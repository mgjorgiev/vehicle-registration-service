package com.vehicle.service;

import com.vehicle.dto.response.AccountResponse;

/**
 * Service for Account creation
 */
public interface AccountService {
    /**
     * Create Account
     * @param accountId
     *           the accountId
     * @return AccountResponse
     */
    AccountResponse addNewAccount(String accountId);
}
