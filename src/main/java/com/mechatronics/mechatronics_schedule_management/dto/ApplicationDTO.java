package com.mechatronics.mechatronics_schedule_management.dto;

import com.mechatronics.mechatronics_schedule_management.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
    private Date appliedAt;
    private Long taskId;
    private Long userId;
    private Status status;
}