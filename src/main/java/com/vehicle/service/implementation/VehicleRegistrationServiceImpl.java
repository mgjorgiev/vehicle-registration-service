package com.vehicle.service.implementation;

import com.vehicle.domain.entity.Account;
import com.vehicle.domain.entity.VehicleRegistration;
import com.vehicle.domain.repository.AccountRepository;
import com.vehicle.domain.repository.VehicleRegistrationRepository;
import com.vehicle.dto.request.VehicleRegistrationRequest;
import com.vehicle.dto.response.RegistrationCodeResponse;
import com.vehicle.dto.response.VehicleRegistrationResponse;
import com.vehicle.service.VehicleRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleRegistrationServiceImpl implements VehicleRegistrationService {

    private final VehicleRegistrationRepository vehicleRegistrationRepository;

    private final AccountRepository accountRepository;

    public VehicleRegistrationServiceImpl(VehicleRegistrationRepository vehicleRegistrationRepository,
                                          AccountRepository accountRepository) {
        this.vehicleRegistrationRepository = vehicleRegistrationRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public VehicleRegistrationResponse register(VehicleRegistrationRequest vehicleRegistrationRequest, String accountId,
                                                String password) {

        Account account = this.accountRepository.findAccountByUsernameAndPassword(accountId, password)
                                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                                                                                               "AccountID or username is not correct !"));

        Optional<VehicleRegistration> existingRegistrationCode = this.vehicleRegistrationRepository.findVehicleRegistrationByRegistrationCode(
            vehicleRegistrationRequest.getRegistrationCode());

        if (existingRegistrationCode.isPresent()) {
            return new VehicleRegistrationResponse(false, "Provided registration code already exist");
        }

        addNewRegistration(vehicleRegistrationRequest, account);
        return new VehicleRegistrationResponse(true, "Vehicle registration is successfully added");
    }

    @Override
    public Map<String, Integer> getStatistic(String accountId, String password) {
        this.accountRepository.findAccountByUsernameAndPassword(accountId, password)
                              .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                                                                             "AccountID or username is not correct !"));
        Map<String, Integer> result = new HashMap<>();
        this.accountRepository.findAll()
                              .forEach(account -> {
                                  result.put(account.getUsername(),
                                             this.vehicleRegistrationRepository.countVehicleRegistrationByAccount(
                                                 account));
                              });
        return result;
    }

    @Override
    public RegistrationCodeResponse validateRegistrationCode(String registrationCode) {
        Optional<VehicleRegistration> vehicleRegistration = this.vehicleRegistrationRepository.findVehicleRegistrationByRegistrationCode(
            registrationCode);
        if (!vehicleRegistration.isPresent()) {
            return new RegistrationCodeResponse("Your registration code is not recognized.");
        }
        if(LocalDate.now().isAfter(vehicleRegistration.get().getExpiraianDate())){
            return new RegistrationCodeResponse(vehicleRegistration.get().getExpiraianDate(),"Your registration has expired.");
        }
        return new RegistrationCodeResponse(vehicleRegistration.get().getExpiraianDate(),"Your registration is still valid.");
    }

    private void addNewRegistration(VehicleRegistrationRequest vehicleRegistrationRequest, Account account) {
        VehicleRegistration vehicleRegistration = new VehicleRegistration();
        vehicleRegistration.setRegistrationCode(vehicleRegistrationRequest.getRegistrationCode());
        vehicleRegistration.setExpiraianDate(vehicleRegistrationRequest.getValidUntil()
                                                                       .plusYears(1));
        vehicleRegistration.setAccount(account);
        this.vehicleRegistrationRepository.save(vehicleRegistration);
    }

}
