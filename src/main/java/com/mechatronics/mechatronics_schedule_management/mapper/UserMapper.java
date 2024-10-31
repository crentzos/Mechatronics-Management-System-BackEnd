package com.mechatronics.mechatronics_schedule_management.mapper;

import com.mechatronics.mechatronics_schedule_management.dto.UserDTO;
import org.apache.catalina.User;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
