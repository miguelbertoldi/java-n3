package br.edu.catolicasc.to_do.repository;

import br.edu.catolicasc.to_do.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository
        extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

}
