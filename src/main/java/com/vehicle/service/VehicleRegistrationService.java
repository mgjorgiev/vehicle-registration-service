package com.vehicle.service;

import com.vehicle.dto.request.VehicleRegistrationRequest;
import com.vehicle.dto.response.RegistrationCodeResponse;
import com.vehicle.dto.response.VehicleRegistrationResponse;

import java.util.Map;

/**
 * Service for VehicleRegistration
 */
public interface VehicleRegistrationService {
    /**
     * Register vehicle
     * @param vehicleRegistrationRequest
     *           the vehicleRegistrationRequest
     * @param accountId
     *          the accountId
     * @param password
     *          the password
     * @return
     */
    VehicleRegistrationResponse register(VehicleRegistrationRequest vehicleRegistrationRequest, String accountId, String password);

    /**
     * Returns statistics from all accounts and number of
     * @param accountId
     *          the accountId
     * @param password
     *          the password
     * @return
     */
    Map<String, Integer> getStatistic(String accountId, String password);

    /**
     * Checking registrationCode
     * @param registrationCode
     *           the registrationCode
     * @return
     */
    RegistrationCodeResponse validateRegistrationCode(String registrationCode);

}
