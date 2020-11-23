package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.NoteDto;
import dmytro.kudriavtsev.auth.lab1.entities.Roles;
import dmytro.kudriavtsev.auth.lab1.entities.User;
import dmytro.kudriavtsev.auth.lab1.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    @PreAuthorize("hasAuthority('PRE_USER')")
    public String indexPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        if (authorities.stream().noneMatch(role -> role.equals(Roles.USER))) {
            return "redirect:/pre-user-page";
        }

        return "index";
    }

    @PostMapping("/add-note")
    public String addNote(@ModelAttribute NoteDto noteDto) {
        noteService.addNote(noteDto);

        return "redirect:/";
    }

    @GetMapping("/pre-user-page")
    @PreAuthorize("hasAuthority('PRE_USER')")
    public String preUserPage() {
        return "preUserPage";
    }

}
