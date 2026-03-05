package benyandadamson.interbank.data.repositories;

import benyandadamson.interbank.data.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
