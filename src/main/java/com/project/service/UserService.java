package com.project.service;

import com.project.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser (UserModel user);
    UserModel findUserById (UserModel user);
    UserModel getUser(UserModel user);

    List<UserModel> userList();
}
