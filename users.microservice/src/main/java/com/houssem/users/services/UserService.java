package com.houssem.users.services;
import java.util.List;

import com.houssem.users.entities.*;
public interface UserService {
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
List<User> findAllUsers();
}