package com.mechatronics.mechatronics_schedule_management.mapper;


import com.mechatronics.mechatronics_schedule_management.dto.UserDTO;
import com.mechatronics.mechatronics_schedule_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
