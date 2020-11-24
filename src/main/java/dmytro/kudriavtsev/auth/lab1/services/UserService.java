package dmytro.kudriavtsev.auth.lab1.services;

import dmytro.kudriavtsev.auth.lab1.dtos.ChangePwDto;
import dmytro.kudriavtsev.auth.lab1.dtos.RegistrationDto;
import dmytro.kudriavtsev.auth.lab1.entities.Roles;
import dmytro.kudriavtsev.auth.lab1.entities.User;
import dmytro.kudriavtsev.auth.lab1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final String DEFAULT_PW = "1111";

    private final int MAX_ATTEMPTS = 3;

    private static final Set<Roles> DEFAULT_USER_ROLES = Collections.singleton(Roles.PRE_USER);

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
        user.setAuthAttempts(0);
        user.setAccountLocked(true);

        String encodePassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodePassword);

        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());

        userRepo.save(user);
    }

    public void changePw(ChangePwDto changePwDto) {
        Optional<User> userMaybe = userRepo.findByEmail(changePwDto.getEmail());

        if (!userMaybe.isPresent()) {
            throw new RuntimeException("User not found!");
        }

        User user = userMaybe.get();

        if (user.getRoles().stream().noneMatch(role -> role.equals(Roles.USER))) {
            user.getRoles().add(Roles.USER);
//            user.getRoles().add(Roles.ADMIN);

            userRepo.save(user);
        }

        boolean isPasswordsEqual = passwordEncoder.matches(changePwDto.getOldPassword(), user.getPassword());

        if (!isPasswordsEqual) {
            throw new RuntimeException("Wrong old password!");
        }

        String encodePassword = passwordEncoder.encode(changePwDto.getNewPassword());

        userRepo.updatePasswordByEmail(user.getEmail(), encodePassword);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void addAttempt(String email) {
        Optional<User> maybeUser = userRepo.findByEmail(email);

        if (!maybeUser.isPresent())
            return;

        User user = maybeUser.get();

        int numOfAttempts = user.getAuthAttempts();
        user.setAuthAttempts(++numOfAttempts);

        if (user.getAuthAttempts() == MAX_ATTEMPTS) {
            user.setAccountLocked(false);
        }

        userRepo.save(user);
    }

    public void resetPw(User user) {
        String encodePassword = passwordEncoder.encode(DEFAULT_PW);
        user.setPassword(encodePassword);

        userRepo.save(user);
    }
}
