package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.UserDTO;
import com.kreitek.kreitekfy.application.mapper.UserMapper;
import com.kreitek.kreitekfy.application.service.UserService;
import com.kreitek.kreitekfy.domain.entity.User;
import com.kreitek.kreitekfy.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserPersistence persistence;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserPersistence persistence, UserMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.persistence.getAllUsers();
        return this.mapper.toDto(users);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return this.persistence.getUserById(userId).map(mapper::toDto);
    }

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        User userSaved = this.persistence.saveUser(this.mapper.toEntity(userDto));
        return this.mapper.toDto(userSaved);
    }

    @Override
    public void deleteUser(Long userId) {
        this.persistence.deleteUser(userId);
    }
}
