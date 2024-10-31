package com.mechatronics.mechatronics_schedule_management.dto;



import com.mechatronics.mechatronics_schedule_management.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private Set<Role> roles;
    private boolean availability;
    private LocalDateTime updatedAt;
    private String email;
}
