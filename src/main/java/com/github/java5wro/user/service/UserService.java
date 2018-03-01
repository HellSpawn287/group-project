package com.github.java5wro.user.service;

import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.model.UserMapper;
import com.github.java5wro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public Set<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(u->UserMapper.toUserDTO(u)).collect(Collectors.toSet());
    }

    public void saveUserEntity(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userEntity, null));
        userRepository.save(userEntity);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findOneByEmail(email).get();
    }

}
