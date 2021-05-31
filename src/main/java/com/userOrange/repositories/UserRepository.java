package com.userOrange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.userOrange.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, String>{

    Optional<User> findByCpf(String Cpf);
    Optional<User> findByEmail(String email);

}
