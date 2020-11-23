package dmytro.kudriavtsev.auth.lab1.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    PRE_USER, USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
