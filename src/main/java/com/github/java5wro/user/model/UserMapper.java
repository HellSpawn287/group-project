package com.github.java5wro.user.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Autowired
    private PasswordEncoder encoder;

    public UserMapper(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = encoder.encode(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserEntity toUserEntity(UserMapper userMapper) {
        return new UserEntity(userMapper.getName(), userMapper.getEmail(), userMapper.getPassword(),"USER");
    }

    public static UserMapper toUserDTO(UserEntity userEntity) {
        return new UserMapper(userEntity.getName(),userEntity.getEmail(),userEntity.getPassword());
    }
}
