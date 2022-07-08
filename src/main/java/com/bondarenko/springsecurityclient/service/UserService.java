package com.bondarenko.springsecurityclient.service;


import com.bondarenko.springsecurityclient.entity.User;
import com.bondarenko.springsecurityclient.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
