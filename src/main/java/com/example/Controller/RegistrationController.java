package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
