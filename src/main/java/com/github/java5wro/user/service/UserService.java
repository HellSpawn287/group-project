package com.github.java5wro.user.service;

import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
//        createSampleUser();
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    private void createSampleUser() {
        if (!findByEmail("user@user.pl").isPresent()) {
            User entity = new User("user@user.pl" ,encoder.encode("user1"),"USER");
            userRepository.save(entity);
        }
    }


}
