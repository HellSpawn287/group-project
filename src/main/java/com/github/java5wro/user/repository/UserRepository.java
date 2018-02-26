package com.github.java5wro.user.repository;

import com.github.java5wro.user.model.User;
import com.github.java5wro.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<User> findOneByEmail(String email);

}
