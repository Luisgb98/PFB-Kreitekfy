package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long userId);
    UserDTO saveUser(UserDTO userDto);
    void deleteUser(Long userId);
}
