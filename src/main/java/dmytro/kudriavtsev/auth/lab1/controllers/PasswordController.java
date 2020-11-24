package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.ChangePwDto;
import dmytro.kudriavtsev.auth.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pw")
public class PasswordController {

    @Autowired
    private UserService userService;

    @GetMapping("/change")
    public String changePwPage() {
        return "changePage";
    }

    @PostMapping("/change")
    public String changePw(@ModelAttribute ChangePwDto changePwDto) {
        userService.changePw(changePwDto);

        return "redirect:/login";
    }

    @PostMapping("/add-attempt")
    public String addAttempt(@ModelAttribute String email) {
        userService.addAttempt(email);

        return "redirect:/login";
    }

}
