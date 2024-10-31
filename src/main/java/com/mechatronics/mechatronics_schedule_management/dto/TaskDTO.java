package com.mechatronics.mechatronics_schedule_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;

@Data
@AllArgsConstructor
public class TaskDTO {
        private Long id;
        private String title;
        private String description;
        private Date postedDate;
        private Date expirationDate;
        private int availablePositions;
        private Long createdById;
}
