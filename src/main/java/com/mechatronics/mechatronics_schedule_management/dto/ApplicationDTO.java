package com.mechatronics.mechatronics_schedule_management.dto;

import com.mechatronics.mechatronics_schedule_management.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class ApplicationDTO {
    private Date applicationDate;
    private Long taskId;
    private Long userId;
    private Set<Status> status;
}