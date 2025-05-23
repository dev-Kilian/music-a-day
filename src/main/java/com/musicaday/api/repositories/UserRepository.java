package com.musicaday.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicaday.api.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // methods go here, such as deleteByName etc etc
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    void deleteByUsername(String username);
}
