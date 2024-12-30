package org.example.test.security.controller;

import lombok.AllArgsConstructor;
import org.example.test.security.entities.AppRole;
import org.example.test.security.entities.AppUser;
import org.example.test.security.repository.AppRoleRepository;
import org.example.test.security.repository.AppUserRepository;
import org.example.test.security.service.ServiceAuthentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    ServiceAuthentication serviceAuthentication;
 AppUserRepository appUserRepository;
AppRoleRepository appRoleRepository;
    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
        AppUser createdUser = serviceAuthentication.createAppUser(user);
        return ResponseEntity.ok(createdUser);
    }


    @PostMapping("/roles")
    public ResponseEntity<AppRole> createRole(@RequestBody AppRole role) {
        AppRole createdRole = serviceAuthentication.createAppRole(role);
        return ResponseEntity.ok(createdRole);
    }


    @PostMapping("/addrole")
    public void addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        serviceAuthentication.addRoleUser(username, roleName);

    }
}
