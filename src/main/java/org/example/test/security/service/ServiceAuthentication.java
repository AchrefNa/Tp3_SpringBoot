package org.example.test.security.service;

import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.test.security.entities.AppRole;
import org.example.test.security.entities.AppUser;
import org.example.test.security.repository.AppRoleRepository;
import org.example.test.security.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAuthentication implements IServiceAuthentication {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public AppUser createAppUser(AppUser user) {
        if (appUserRepository.findByUsername(user.getUsername()) != null) {
            throw new EntityExistsException("Username already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole createAppRole(AppRole role) {
        if (appRoleRepository.findByRole(role.getRole()) != null) {
            throw new EntityExistsException("Role already exists.");
        }
        return appRoleRepository.save(role);

    }

    @Override
    public void addRoleUser(String userName, String roleName) {
        AppUser user = appUserRepository.findByUsername(userName);
        AppRole role = appRoleRepository.findByRole(roleName);
        if (!user.getRoles().contains(role))
            user.getRoles().add(role);
        appUserRepository.save(user);
    }

    @Override
    public AppUser LoadUserByUserName(String userName) {
        AppUser user = appUserRepository.findByUsername(userName);

        return user;
    }
}
