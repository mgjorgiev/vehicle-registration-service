package com.vehicle.controller;

import com.vehicle.dto.request.AccountRequest;
import com.vehicle.dto.request.VehicleRegistrationRequest;
import com.vehicle.dto.response.AccountResponse;
import com.vehicle.dto.response.RegistrationCodeResponse;
import com.vehicle.dto.response.VehicleRegistrationResponse;
import com.vehicle.service.AccountService;
import com.vehicle.service.VehicleRegistrationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Vehicle registration Api Resource
 */
@RestController
public class VehicleRegistrationController {

    private final AccountService accountService;

    private final VehicleRegistrationService vehicleRegistrationService;

    public VehicleRegistrationController(AccountService accountService,
                                         VehicleRegistrationService vehicleRegistrationService) {
        this.accountService = accountService;
        this.vehicleRegistrationService = vehicleRegistrationService;
    }

    /**
     * Create new account by given accountId
     * @param accountRequest
     *              the accountRequest
     * @return AccountResponse
     */
    @PostMapping("/account")
    public AccountResponse test(@Valid @RequestBody AccountRequest accountRequest) {
        return this.accountService.addNewAccount(accountRequest.getAccountId());
    }

    /**
     * Register vehicle
     * @param vehicleRegistrationRequest
     *              the vehicleRegistrationService
     * @param accountId
     *              the accountId
     * @param password
     *              the password
     * @return VehicleRegistrationResponse
     */
    @PostMapping("/register")
    public VehicleRegistrationResponse registerVehicle(
        @Valid @RequestBody VehicleRegistrationRequest vehicleRegistrationRequest,
        @RequestHeader(value = "accountId") String accountId, @RequestHeader(value = "password") String password) {
        return this.vehicleRegistrationService.register(vehicleRegistrationRequest, accountId, password);
    }

    /**
     * Get statistics for the accounts and its count of created vehicle registration
     * @param accountId
     *              the accountId
     * @param password
     *              the password
     * @return
     */
    @GetMapping("/statistics")
    public Map<String, Integer> getStatistics(@RequestHeader(value = "accountId") String accountId,
                                              @RequestHeader(value = "password") String password) {

        return this.vehicleRegistrationService.getStatistic(accountId, password);
    }

    /**
     * Get status by given registration code
     * @param registrationCode
     *              the registrationCode
     * @return RegistrationCodeResponse
     */
    @GetMapping("/statistics/{registrationCode}")
    public RegistrationCodeResponse checkRegistrationCode(@PathVariable String registrationCode) {

        return this.vehicleRegistrationService.validateRegistrationCode(registrationCode);
    }

}
