package com.vehicle.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.Size;

/**
 * Account Api Response.
 */
@JsonInclude(Include.NON_NULL)
public class AccountResponse {

    private boolean success;

    private String description;

    @Size(max = 8,min = 8)
    private String password;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
