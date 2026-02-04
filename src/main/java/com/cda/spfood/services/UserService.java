package com.cda.spfood.services;

import com.cda.spfood.dtos.users.UserRequestDTO;
import com.cda.spfood.dtos.users.UserResponseDTO;
import com.cda.spfood.entities.User;
import com.cda.spfood.mappers.UserMapper;
import com.cda.spfood.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTO(users);
    }

    public UserResponseDTO find(Integer id) {
        User user = null;
        if (userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
        }
        return userMapper.toDTO(user);
    }

    public void update(Integer id, UserRequestDTO userRequestDTO) {
        userRepository.save(userMapper.toEntity(userRequestDTO));
    }

    public void save(UserRequestDTO userRequestDTO) {
        userRepository.save(userMapper.toEntity(userRequestDTO));
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
