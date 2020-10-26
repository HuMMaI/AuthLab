package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.RegistrationDto;
import dmytro.kudriavtsev.auth.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String registrationPage() {
        return "registration";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute RegistrationDto registrationDto) {
        userService.addNewUser(registrationDto);

        return "redirect:/login";
    }

}
