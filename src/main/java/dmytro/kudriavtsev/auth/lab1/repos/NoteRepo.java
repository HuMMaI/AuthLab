package dmytro.kudriavtsev.auth.lab1.repos;

import dmytro.kudriavtsev.auth.lab1.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
}
