package com.mechatronics.mechatronics_schedule_management.entity;

import com.mechatronics.mechatronics_schedule_management.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;

public class Application {
    private Long id;
    private Date appliedAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany
    private Task task;
    @ManyToOne
    private User user;
}

