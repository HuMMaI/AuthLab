package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.entities.User;
import dmytro.kudriavtsev.auth.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/api")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String usersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "usersPage";
    }

    @PostMapping("/reset-pw/{id}")
    public String resetPw(@PathVariable("id") User user) {
        userService.resetPw(user);

        return "redirect:/admin/api";
    }
}
