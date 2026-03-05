package benyandadamson.interbank.data.repositories;

import benyandadamson.interbank.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
