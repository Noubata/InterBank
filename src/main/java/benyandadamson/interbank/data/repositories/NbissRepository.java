package benyandadamson.interbank.data.repositories;

import benyandadamson.interbank.data.models.Nbiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbissRepository extends JpaRepository<Nbiss, Long> {
}
