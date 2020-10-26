package dmytro.kudriavtsev.auth.lab1.services;

import dmytro.kudriavtsev.auth.lab1.dtos.RegistrationDto;
import dmytro.kudriavtsev.auth.lab1.entities.Roles;
import dmytro.kudriavtsev.auth.lab1.entities.User;
import dmytro.kudriavtsev.auth.lab1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService {

    private static final Set<Roles> DEFAULT_USER_ROLES = Collections.singleton(Roles.USER);

    private final UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addNewUser(RegistrationDto registrationDto) {
        User user = new User();

        user.setEmail(registrationDto.getEmail());
        user.setRoles(DEFAULT_USER_ROLES);

        String encodePassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodePassword);

        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());

        userRepo.save(user);
    }
}
