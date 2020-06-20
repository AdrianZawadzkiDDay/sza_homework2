package pl.bykowski.spring_secutity_homework2.controller;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import pl.bykowski.spring_secutity_homework2.services.LoginCounter;

@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent>  {

    private LoginCounter loginCounter;

    @Autowired
    public LoginListener(LoginCounter loginCounter) {
        this.loginCounter = loginCounter;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        loginCounter.incrementCounter(authenticationSuccessEvent.getAuthentication().getName());
    }
}
