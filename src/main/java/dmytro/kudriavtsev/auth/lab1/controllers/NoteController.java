package dmytro.kudriavtsev.auth.lab1.controllers;

import dmytro.kudriavtsev.auth.lab1.dtos.EditNoteDto;
import dmytro.kudriavtsev.auth.lab1.entities.Note;
import dmytro.kudriavtsev.auth.lab1.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
@PreAuthorize("hasAuthority('USER')")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String notesPage(Model model) {
        List<Note> notes = noteService.getNotes();

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

}
