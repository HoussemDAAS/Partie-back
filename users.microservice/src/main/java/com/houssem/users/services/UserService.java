package com.houssem.users.services;
import java.util.List;

import com.houssem.users.entities.*;
import com.houssem.users.services.register.RegistationRequest;
public interface UserService {
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
List<User> findAllUsers();
User registerUser(RegistationRequest request);
public User validateToken(String code);
}