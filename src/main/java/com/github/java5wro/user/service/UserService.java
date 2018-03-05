package com.github.java5wro.user.service;

import com.github.java5wro.user.UserNotFoundException;
import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.model.UserMapper;
import com.github.java5wro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    public Set<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(toSet());
    }

    public UserDTO findUserById(Long id) {
        return userMapper.toUserDTO(userRepository.findOne(id));
    }

    public void saveUser(UserDTO user) {

        UserEntity userEntity = new UserEntity(user.getName(),user.getMail(),encoder.encode(user.getPassword()),"USER");
        userRepository.save(userEntity);
    }

    public UserDTO findUserByEmail(String email) {
        return userMapper.toUserDTO(userRepository.findOneByEmail(email).orElseThrow(UserNotFoundException::new));
    }
}
