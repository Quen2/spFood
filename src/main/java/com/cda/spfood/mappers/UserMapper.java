package com.cda.spfood.mappers;

import com.cda.spfood.dtos.users.UserRequestDTO;
import com.cda.spfood.dtos.users.UserResponseDTO;
import com.cda.spfood.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toDTO(User user);
    List<UserResponseDTO> toDTO(List<User> users);

    User toEntity(UserRequestDTO dto);
}
