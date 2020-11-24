package dmytro.kudriavtsev.auth.lab1.repos;

import dmytro.kudriavtsev.auth.lab1.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Note n SET n.title = :title, n.note = :note WHERE n.id = :id")
    void updateNote(@Param("title") String title, @Param("note") String note, @Param("id") int id);

    List<Note> findByUserId(int id);
}
