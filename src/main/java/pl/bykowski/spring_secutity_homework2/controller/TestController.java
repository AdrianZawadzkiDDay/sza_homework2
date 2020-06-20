package pl.bykowski.spring_secutity_homework2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bykowski.spring_secutity_homework2.services.MessageConstructor;

import java.security.Principal;

@RestController
public class TestController {

    private MessageConstructor messageConstructor;

    @Autowired
    public TestController(MessageConstructor messageConstructor) {
        this.messageConstructor = messageConstructor;
    }

    @GetMapping("/forAdmin")
    public ResponseEntity<String> getAdmin(Principal principal) {
        return new ResponseEntity<>(messageConstructor.getMessageForAdmin(principal), HttpStatus.OK);
    }

    @GetMapping("/forUser")
    public ResponseEntity<String> getUser(Principal principal) {
        return new ResponseEntity<>(messageConstructor.getMessageForUser(principal), HttpStatus.OK);
    }

    @GetMapping("/forAll")
    public ResponseEntity<String> forAll(Principal principal) {
        return new ResponseEntity<>(messageConstructor.getMessageForUserDependentByRole(principal), HttpStatus.OK);
    }

    @GetMapping("/bye")
    public ResponseEntity<String> getBye() {
        return new ResponseEntity<>("papa", HttpStatus.OK);
    }

}
