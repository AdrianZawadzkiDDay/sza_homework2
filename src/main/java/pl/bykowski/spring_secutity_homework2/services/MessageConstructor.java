package pl.bykowski.spring_secutity_homework2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class MessageConstructor {


    private static final String LOGIN_COUNTER_MESSAGE = "   number of logging: ";

    private LoginCounter loginCounter;

    @Autowired
    public MessageConstructor(LoginCounter loginCounter) {
        this.loginCounter = loginCounter;
    }

    public String getMessageForUserDependentByRole(Principal principal) {
        if (principal != null) {
            return "Hello " + principal.getName();
        }
        return "Hello anonymous ";
    }

    public String getMessageForUser(Principal principal) {
        return "Hello user " + principal.getName() + LOGIN_COUNTER_MESSAGE + loginCounter.getCountByUsername(principal.getName());
    }

    public String getMessageForAdmin(Principal principal) {
        return "Hello admin " + principal.getName() + LOGIN_COUNTER_MESSAGE + loginCounter.getCountByUsername(principal.getName());
    }

}
