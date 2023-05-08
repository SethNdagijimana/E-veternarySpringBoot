package com.project.controller;

import com.project.model.UserAppointmentModel;
import com.project.repository.AppointmentRepository;
import com.project.service.implementation.AppointmentImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;
    private final AppointmentImplementation appService;

    public AppointmentController(AppointmentImplementation appService){
        this.appService = appService;
    }

    @GetMapping("/registerAppointment")
    public String appointmentPage(Model model){
        model.addAttribute("appointmentRequest", new UserAppointmentModel());
        return "appointment";
    }

    @GetMapping("/appointments")
    public String appointmentList(Model model){
        List<UserAppointmentModel> ListOfAppointment = appService.appointmentList();
        model.addAttribute("ListOfAppointment", ListOfAppointment);

        return "Display";
    }

    @PostMapping("/registerAppointment")
    public String register(@ModelAttribute UserAppointmentModel appointment){
        System.out.println("register request: " + appointment);
        UserAppointmentModel registerAppointment = appService.registerAppointment(appointment);

        return registerAppointment == null ? "error_page" : "redirect:/appointments";
    }

    @GetMapping("/UpdateAppointment/{id}")
    public String updateAppointment(@PathVariable("id") Integer id, Model model){
        Optional<UserAppointmentModel> apps = appointmentRepository.findFirstById(id);
        UserAppointmentModel userApps = apps.get();
        model.addAttribute("appointment", userApps);

        return "Edit_pag";
    }

    @GetMapping("DeleteAppointment/{id}")
    public String deleteAppointment(@PathVariable("id") Integer id){
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

}
