package ru.fenix.proxy_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fenix.proxy_api.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
}
