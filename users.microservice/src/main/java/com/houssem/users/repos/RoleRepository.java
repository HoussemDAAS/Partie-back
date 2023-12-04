package com.houssem.users.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.users.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}