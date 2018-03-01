package com.github.java5wro.user.repository;

import com.github.java5wro.user.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<VerificationToken,Long> {
}
