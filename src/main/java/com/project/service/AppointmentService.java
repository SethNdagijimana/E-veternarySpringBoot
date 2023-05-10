package com.project.service;

import com.project.model.UserAppointmentModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentService {

    UserAppointmentModel registerAppointment (UserAppointmentModel appointment);
    UserAppointmentModel updateAppointment( UserAppointmentModel appointment);
    void deleteAppointmentById (UserAppointmentModel appointment);
    List<UserAppointmentModel> appointmentList();
    UserAppointmentModel findAppointmentById(UserAppointmentModel appointment);

    Page<UserAppointmentModel> findPage(int pageNo, int pageSize);
}
