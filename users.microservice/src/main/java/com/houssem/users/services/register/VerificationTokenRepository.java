package com.houssem.users.services.register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends
JpaRepository<VerificationToken, Long> {
 VerificationToken findByToken(String token);
}