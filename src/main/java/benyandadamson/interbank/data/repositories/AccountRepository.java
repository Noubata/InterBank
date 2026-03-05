package benyandadamson.interbank.data.repositories;

import benyandadamson.interbank.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
