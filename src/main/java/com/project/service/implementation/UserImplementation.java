package com.project.service.implementation;

import com.project.model.UserModel;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public UserModel createUser(UserModel user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sethrea@gmail.com");
        message.setTo(user.getEmail());
        message.setText("Thank You for Sign up to E-veternary if it was not you Please Ignore this message");
        message.setSubject("Confirmation Email");

        mailSender.send(message);
        return userRepo.save(user);

    }

    @Override
    public UserModel findUserById(UserModel user) {
        return userRepo.findById(user.getId()).get();
    }

    @Override
    public UserModel getUser(UserModel user) {
        return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }

    @Override
    public List<UserModel> userList() {
        return userRepo.findAll();
    }
}
