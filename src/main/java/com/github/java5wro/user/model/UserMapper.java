package com.github.java5wro.user.model;

public class UserMapper {

    public static UserEntity toUserEntity(UserDTO userDTO) {
        return new UserEntity(userDTO.getName(),userDTO.getEmail(),userDTO.getPassword(),"USER");
    }

    public static UserDTO toUserDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getName(),userEntity.getEmail(),userEntity.getPassword());
    }
}
