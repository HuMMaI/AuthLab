package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.NoteDto;
import dmytro.kudriavtsev.auth.lab1.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @PostMapping("/add-note")
    public String addNote(@ModelAttribute NoteDto noteDto) {
        noteService.addNote(noteDto);

        return "redirect:/";
    }

}
