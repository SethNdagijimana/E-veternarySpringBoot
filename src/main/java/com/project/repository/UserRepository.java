package com.project.repository;

import com.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
