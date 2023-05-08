package com.project.service;

import com.project.model.UserAppointmentModel;

import java.util.List;

public interface AppointmentService {

    UserAppointmentModel registerAppointment (UserAppointmentModel appointment);
    UserAppointmentModel updateAppointment( UserAppointmentModel appointment);
    void deleteAppointmentById (UserAppointmentModel appointment);
    List<UserAppointmentModel> appointmentList();

    UserAppointmentModel findAppointmentById(UserAppointmentModel appointment);
}
