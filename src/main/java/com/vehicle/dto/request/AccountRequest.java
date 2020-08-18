package com.vehicle.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class AccountRequest {

    @Email
    private String accountId;

    @Size(max = 8, min = 8)
    private String password;

    public AccountRequest() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
