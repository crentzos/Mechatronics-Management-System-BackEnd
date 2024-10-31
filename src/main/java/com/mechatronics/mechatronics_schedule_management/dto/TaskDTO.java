package com.mechatronics.mechatronics_schedule_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class TaskDTO {
        private Long id;
        private String title;
        private String description;
        private LocalDateTime postedDate;
        private LocalDateTime expirationDate;
        private int availablePositions;
        private Long createdById;
}
