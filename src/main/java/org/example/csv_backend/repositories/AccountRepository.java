package org.example.csv_backend.repositories;

import org.example.csv_backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
