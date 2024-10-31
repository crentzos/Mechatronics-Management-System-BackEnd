package com.mechatronics.mechatronics_schedule_management.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private Set<String > roles;
    private boolean availability;
    private Date updatedAt;
    private String email;
}
