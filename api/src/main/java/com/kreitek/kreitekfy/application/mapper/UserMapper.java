package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.UserDTO;
import com.kreitek.kreitekfy.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
    default User fromId(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }
}
