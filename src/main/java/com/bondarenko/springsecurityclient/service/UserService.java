package com.bondarenko.springsecurityclient.service;


import com.bondarenko.springsecurityclient.entity.User;
import com.bondarenko.springsecurityclient.entity.VerificationToken;
import com.bondarenko.springsecurityclient.model.UserModel;

import java.util.Optional;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenFroUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
