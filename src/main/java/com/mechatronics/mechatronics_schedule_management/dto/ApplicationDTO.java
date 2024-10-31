package com.mechatronics.mechatronics_schedule_management.dto;

import com.mechatronics.mechatronics_schedule_management.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApplicationDTO {
    private Long id;
    private Date appliedAt;
    private Long taskId;
    private Long userId;
    private ApplicationStatus applicationStatus;
}