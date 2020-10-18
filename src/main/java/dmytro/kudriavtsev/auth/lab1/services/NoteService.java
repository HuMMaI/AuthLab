package dmytro.kudriavtsev.auth.lab1.services;

import dmytro.kudriavtsev.auth.lab1.dtos.NoteDto;
import dmytro.kudriavtsev.auth.lab1.entities.Note;
import dmytro.kudriavtsev.auth.lab1.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public void addNote(NoteDto noteDto) {
        Note note = new Note();

        note.setTitle(noteDto.getTitle());
        note.setNote(noteDto.getNote());

        noteRepo.save(note);
    }

    public List<Note> getNotes() {
        return noteRepo.findAll();
    }

}
