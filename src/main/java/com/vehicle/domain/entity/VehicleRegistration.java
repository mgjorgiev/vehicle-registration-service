package com.vehicle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Entity VehicleRegistration class
 */
@Entity
public class VehicleRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String registrationCode;

    @NotNull
    private LocalDate expiraianDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public LocalDate getExpiraianDate() {
        return expiraianDate;
    }

    public void setExpiraianDate(LocalDate expiraianDate) {
        this.expiraianDate = expiraianDate;
    }

}
