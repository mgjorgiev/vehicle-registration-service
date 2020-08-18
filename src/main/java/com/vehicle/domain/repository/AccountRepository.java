package com.vehicle.domain.repository;

import com.vehicle.domain.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByUsername(String username);
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);
}
