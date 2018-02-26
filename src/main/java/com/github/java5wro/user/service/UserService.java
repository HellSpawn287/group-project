package com.github.java5wro.user.service;

import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.model.UserMapper;
import com.github.java5wro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(u->UserMapper.toUserDTO(u)).collect(Collectors.toSet());
    }

    public UserDTO findUserById(Long id) {
        return UserMapper.toUserDTO(userRepository.findOne(id));
    }

    public void saveUser(UserDTO user) {
        UserEntity userEntity = new UserEntity(user.getName(),user.getEmail(),encoder.encode(user.getPassword()),"USER");
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

//    private void createSampleUser() {
//        if (!findByEmail("user@user.pl").isPresent()) {
//            UserEntity entity = new UserEntity("user@user.pl" ,encoder.encode("user1"),"USER");
//            userRepository.save(entity);
//        }
//    }


}
