package com.github.java5wro.user.service;

import com.github.java5wro.user.model.User;
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
        createSampleUser();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    private void createSampleUser() {
        if (!findByEmail("user@user.pl").isPresent()) {
            User entity = new User("user@user.pl" ,encoder.encode("user1"),"ROLE_USER");
            userRepository.save(entity);
        }
    }


}
