package com.mechatronics.mechatronics_schedule_management;

import com.mechatronics.mechatronics_schedule_management.dao.UserRepository;
import com.mechatronics.mechatronics_schedule_management.dto.UserDTO;
import com.mechatronics.mechatronics_schedule_management.entity.User;
import com.mechatronics.mechatronics_schedule_management.enums.Role;
import com.mechatronics.mechatronics_schedule_management.mapper.UserMapper;
import com.mechatronics.mechatronics_schedule_management.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private UserDTO userDTO;
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);


        userDTO = new UserDTO("testUser", roles, true, LocalDateTime.now(), "test@example.com");


        user = new User("testUser", roles, true, "test@example.com", new HashSet<>());
    }

    @Test
    public void testCreateUser() {
        when(userMapper.userDTOToUser(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        UserDTO createdUserDTO = userService.createUser(userDTO);

        assertNotNull(createdUserDTO);
        verify(userMapper).userDTOToUser(userDTO);
        verify(userRepository).save(user);
        verify(userMapper).userToUserDTO(user);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        List<UserDTO> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(userRepository).findAll();
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        UserDTO foundUserDTO = userService.getUserById(userId);

        assertNotNull(foundUserDTO);
        verify(userRepository).findById(userId);
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;
        when(userRepository.existsById(userId)).thenReturn(true);
        when(userMapper.userDTOToUser(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        UserDTO updatedUserDTO = userService.updateUser(userId, userDTO);

        assertNotNull(updatedUserDTO);
        verify(userRepository).existsById(userId);
        verify(userRepository).save(user);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        when(userRepository.existsById(userId)).thenReturn(true);

        boolean result = userService.deleteUser(userId);

        assertTrue(result);
        verify(userRepository).deleteById(userId);
    }

    @Test
    public void testDeleteUserNotFound() {
        Long userId = 2L;
        when(userRepository.existsById(userId)).thenReturn(false);

        boolean result = userService.deleteUser(userId);

        assertFalse(result);
        verify(userRepository, never()).deleteById(userId);
    }
}
