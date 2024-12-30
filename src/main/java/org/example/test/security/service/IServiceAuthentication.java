package org.example.test.security.service;

import org.example.test.security.entities.AppRole;
import org.example.test.security.entities.AppUser;

public interface IServiceAuthentication {
public AppUser createAppUser(AppUser user);
public AppRole createAppRole(AppRole role);
public void addRoleUser(String userName, String roleName);
public AppUser LoadUserByUserName(String userName);
}
