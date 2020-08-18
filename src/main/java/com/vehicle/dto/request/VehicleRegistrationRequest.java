package com.vehicle.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

public class VehicleRegistrationRequest
{
    @NotBlank
    private String registrationCode;
    private LocalDate validUntil;

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
