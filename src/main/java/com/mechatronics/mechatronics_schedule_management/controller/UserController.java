package com.mechatronics.mechatronics_schedule_management.controller;


import com.mechatronics.mechatronics_schedule_management.dto.UserDTO;
import com.mechatronics.mechatronics_schedule_management.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController  {

   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @PostMapping("/add/user")
   public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
      UserDTO createdUser = userService.createUser(userDTO);
      return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
   }

   @GetMapping
   public ResponseEntity<List<UserDTO>> getAllUsers() {
      List<UserDTO> users = userService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
      UserDTO user = userService.getUserById(id);
      if (user != null) {
         return new ResponseEntity<>(user, HttpStatus.OK);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

   @PutMapping("/{id}")
   public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
      UserDTO updatedUser = userService.updateUser(id, userDTO);
      if (updatedUser != null) {
         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
      boolean userDeleted = userService.deleteUser(id);
      if (userDeleted) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }
}
