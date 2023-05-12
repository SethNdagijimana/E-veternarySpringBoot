package com.project.repository;

import com.project.model.UserAppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<UserAppointmentModel, Integer> {

    Optional<UserAppointmentModel> findById(Integer id);

    boolean existsByEmail(String email);
    Optional<UserAppointmentModel> findFirstById(Integer id);

    @Query("SELECT p FROM UserAppointmentModel p WHERE CONCAT(p.fullName,' ',p.number, ' ',p.email, ' ',p.date, ' ', p.time, ' ',p.country, p.city) LIKE %?1%")
    public List<UserAppointmentModel> search(String keyword);
}
