package com.project.repository;

import com.project.model.UserAppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<UserAppointmentModel, Integer> {

    Optional<UserAppointmentModel> findById(Integer id);

    boolean existsByEmail(String email);
    Optional<UserAppointmentModel> findFirstById(Integer id);
}
