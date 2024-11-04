package com.mechatronics.mechatronics_schedule_management;


import com.mechatronics.mechatronics_schedule_management.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOTest {
    private String username;
    private Set<Role> roles;
    private boolean availability;
    private LocalDateTime updatedAt;
    private String email;

    public static void main(String[] args) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        UserDTOTest userDTO = new UserDTOTest("testUser", roles, true, LocalDateTime.now(), "test@example.com");
        System.out.println(userDTO);
    }
}
