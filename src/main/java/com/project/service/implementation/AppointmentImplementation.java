package com.project.service.implementation;

import com.project.model.UserAppointmentModel;
import com.project.repository.AppointmentRepository;
import com.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepo;
    @Override
    public UserAppointmentModel registerAppointment(UserAppointmentModel appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public UserAppointmentModel updateAppointment(UserAppointmentModel appointment) {
        UserAppointmentModel user = findAppointmentById(appointment);
        if(user !=null){
            user.setFullName(appointment.getFullName());
            user.setNumber(appointment.getNumber());
            user.setEmail(appointment.getEmail());
            user.setDate(appointment.getDate());
            user.setTime(appointment.getTime());
            user.setCountry(appointment.getCountry());
            user.setCity(appointment.getCity());

            return appointmentRepo.save(user);
        }else{
            return registerAppointment(appointment);
        }
    }

    @Override
    public void deleteAppointmentById(UserAppointmentModel appointment) {
        appointmentRepo.delete(appointment);
    }

    @Override
    public List<UserAppointmentModel> appointmentList(String keyword) {
        if(keyword != null){
            return appointmentRepo.search(keyword);
        }
        return appointmentRepo.findAll();
    }

    @Override
    public UserAppointmentModel findAppointmentById(UserAppointmentModel appointment) {
        return appointmentRepo.findById(appointment.getId()).get();
    }

    @Override
    public Page<UserAppointmentModel> findPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);

        return this.appointmentRepo.findAll(pageable);
    }
}
