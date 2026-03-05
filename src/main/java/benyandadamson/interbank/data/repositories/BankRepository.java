package benyandadamson.interbank.data.repositories;

import benyandadamson.interbank.data.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
