package com.mechatronics.mechatronics_schedule_management.service;

import com.mechatronics.mechatronics_schedule_management.dao.UserRepository;
import com.mechatronics.mechatronics_schedule_management.dto.UserDTO;
import com.mechatronics.mechatronics_schedule_management.entity.User;
import com.mechatronics.mechatronics_schedule_management.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        try {
            User user = userMapper.userDTOToUser(userDTO);
            User createdUser = userRepository.save(user);

            return userMapper.userToUserDTO(createdUser);
        } catch (Exception e) {
            throw new RuntimeException("User could not be created: " + e.getMessage(),e);
        }
    }

    public List<UserDTO> getAllUsers() {
        try {
            return userRepository.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
        } catch(Exception e) {
            throw new RuntimeException("Could not retrieve users: " + e.getMessage(),e);
        }
    }

    public UserDTO getUserById(Long id){
        try{
            Optional<User> userOptional = userRepository.findById(id);
            return userOptional.map(userMapper::userToUserDTO).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Could not retrieve user by ID: " +e.getMessage(),e);
        }
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        try{
            if (userRepository.existsById(id)){
                User user = userMapper.userDTOToUser(userDTO);
                user.setId(id);
                User updateUser = userRepository.save(user);
                return userMapper.userToUserDTO(updateUser);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("User could not be updated: " + e.getMessage(),e);
        }
    }

    public boolean deleteUser(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage(), e);
        }
    }
}
