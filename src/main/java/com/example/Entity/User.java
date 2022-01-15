package com.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;


@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "please insert username")
    @Size(min = 8, max = 20, message = "username must be {min} - {max} long")
    private String username;
    @NotBlank(message = "please insert password (min. 8 char)")
    @Size(min = 8, max = 20, message = "password must be {min} - {max} long")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotBlank(message = "please insert your email address")
    @Size(min = 8, max = 30, message = "Please insert valid email address")
    private String email;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role);
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

