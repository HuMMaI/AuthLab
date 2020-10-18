package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.entities.Note;
import dmytro.kudriavtsev.auth.lab1.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public String notesPage(Model model) {
        List<Note> notes = noteService.getNotes();

        model.addAttribute("notes", notes);

        return "notesPage";
    }

}
