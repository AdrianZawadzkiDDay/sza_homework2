package pl.bykowski.spring_secutity_homework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/forAll")
    public String forAll() {
        return "everyone have acess here";
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal) {
        return "Hello user: " + principal.getName();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal) {
        return "Hello admin: " + principal.getName();
    }

    @GetMapping("/bye")
    public String getBye(Principal principal) {
        return "papa";
    }

}
