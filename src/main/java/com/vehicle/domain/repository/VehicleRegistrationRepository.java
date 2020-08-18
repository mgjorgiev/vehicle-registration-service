package com.vehicle.domain.repository;

import com.vehicle.domain.entity.Account;
import com.vehicle.domain.entity.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Long> {

    Optional<VehicleRegistration> findVehicleRegistrationByRegistrationCode(String registrationCode);
    int countVehicleRegistrationByAccount(Account account);

}
