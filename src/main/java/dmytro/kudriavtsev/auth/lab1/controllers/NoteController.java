package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.EditNoteDto;
import dmytro.kudriavtsev.auth.lab1.dtos.NoteDto;
import dmytro.kudriavtsev.auth.lab1.entities.Note;
import dmytro.kudriavtsev.auth.lab1.entities.User;
import dmytro.kudriavtsev.auth.lab1.services.NoteService;
import dmytro.kudriavtsev.auth.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/notes")
@PreAuthorize("hasAuthority('USER')")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String notesPage(Model model, Authentication authentication) {
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        Optional<User> userMaybe = userService.findByEmail(principal.getUsername());
        int userId = userMaybe.get().getId();
        List<Note> notes = noteService.getNotesByUserId(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("notes", notes);

        return "notesPage";
    }

    @PostMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") int noteId) {
        noteService.deleteNote(noteId);
        
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String editNotePage(@PathVariable("id") int noteId, Model model) {
        Note note = noteService.findById(noteId);

        model.addAttribute("note", note);

        return "noteEditPage";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute EditNoteDto editNoteDto) {
        noteService.updateNote(editNoteDto);

        return "redirect:/notes";
    }

    @PostMapping("/add-note")
    public String addNote(@ModelAttribute NoteDto noteDto) {
        noteService.addNote(noteDto);

        return "redirect:/notes";
    }

}
