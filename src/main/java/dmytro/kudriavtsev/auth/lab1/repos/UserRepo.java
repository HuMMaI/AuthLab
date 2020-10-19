package dmytro.kudriavtsev.auth.lab1.repos;

import dmytro.kudriavtsev.auth.lab1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
