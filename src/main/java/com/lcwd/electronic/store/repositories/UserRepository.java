package com.lcwd.electronic.store.repositories;

import com.lcwd.electronic.store.entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
   Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User>findByNameContaining(String keyword);


}
