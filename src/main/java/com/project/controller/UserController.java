package com.project.controller;

import com.project.model.UserModel;
import com.project.repository.UserRepository;
import com.project.service.implementation.UserImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserImplementation userService;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/index")
    public String landingPage(Model model){
        model.addAttribute("landingPage", new UserModel());
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "signUp";
    }
    @GetMapping("/login")
    public String getloginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "signIn";
    }
    @GetMapping("/shop")
    public String getshopPage(Model model){
        model.addAttribute("shopRequest", new UserModel());
        return "shop";
    }
    @GetMapping("/error_page")
    public String geterrorPage(Model model){
        model.addAttribute("errorRequest", new UserModel());
        return "error_page";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model){
        model.addAttribute("appointmentPage", new UserModel());
        return "appointment";
    }
    @GetMapping("/home")
    public String dashboard(Model model){
        model.addAttribute("appointmentPage", new UserModel());
        return "homePage";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("register request: " + userModel);
        if(userRepo.existsByEmail(userModel.getEmail())){
//            throw new IllegalArgumentException("Email already exists in the database.");
            System.out.println("Email already exists");
            return "error_page";
        }else {

            UserModel registerUser = new UserModel();
            if(registerUser == null){
                return "error_page";
            }else{
//                userRepo.save(registerUser);
                userService.createUser(userModel);
//        UserModel registerUser = userService.createUser(userModel);
            return "redirect:/login";
            }
        }
//        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login request: " + userModel);
        UserModel authenticate = userService.getUser(userModel);

        if(authenticate !=null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return "homePage";
        }else{
            return "error_page";
        }
    }

}
