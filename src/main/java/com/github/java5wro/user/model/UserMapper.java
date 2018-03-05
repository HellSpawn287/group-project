package com.github.java5wro.user.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "email", target = "mail")
    })
    UserDTO toUserDTO(UserEntity userEntity);

    Set<UserDTO> toUserDTO(Collection<UserEntity> userEntities);
}
