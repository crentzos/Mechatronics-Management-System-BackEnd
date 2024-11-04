package com.mechatronics.mechatronics_schedule_management.dto;



import com.mechatronics.mechatronics_schedule_management.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;



@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private Set<Role> roles;
    private boolean availability;
    private LocalDateTime updatedAt;
    private String email;

    public UserDTO(String username, Set<Role> roles, boolean availability, LocalDateTime updatedAt, String email) {
        this.username = username;
        this.roles = roles;
        this.availability = availability;
        this.updatedAt = updatedAt;
        this.email = email;
    }
}
