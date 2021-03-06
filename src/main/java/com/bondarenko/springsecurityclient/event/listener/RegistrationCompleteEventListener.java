package com.bondarenko.springsecurityclient.event.listener;

import com.bondarenko.springsecurityclient.entity.User;
import com.bondarenko.springsecurityclient.event.RegistrationCompleteEvent;
import com.bondarenko.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void onApplicationEvent(RegistrationCompleteEvent event) {
//        User user = event.getUser();
//        String token = UUID.randomUUID().toString();
//        userService.saveVerificationTokenForUser(token, user);
//
//        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
//
//        log.info("Click the link to verify your account: {}", url);
//    }
@Autowired
private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification Token for the User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
}
