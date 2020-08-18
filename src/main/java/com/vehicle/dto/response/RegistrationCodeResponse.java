package com.vehicle.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDate;

/**
 * Registration Code Api Response.
 */
@JsonInclude(Include.NON_NULL)
public class RegistrationCodeResponse {

    private LocalDate validUntil;

    private String message;

    public RegistrationCodeResponse(LocalDate validUntil, String message) {
        this.validUntil = validUntil;
        this.message = message;
    }

    public RegistrationCodeResponse(String message) {
        this.message = message;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
