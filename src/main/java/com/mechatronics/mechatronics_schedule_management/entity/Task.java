package com.mechatronics.mechatronics_schedule_management.entity;

import com.mechatronics.mechatronics_schedule_management.enums.Role;
import com.mechatronics.mechatronics_schedule_management.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@Table
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime postedDate;
    private LocalDateTime expirationDate;
    private int availablePositions;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String location;
    @ManyToOne
    private User createdBy;

    public Task(String title, String description, LocalDateTime postedDate, LocalDateTime expirationDate, int availablePositions, Role role, Status status, String location, User createdBy) {
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.availablePositions = availablePositions;
        this.role = role;
        this.status = status;
        this.location = location;
        this.createdBy = createdBy;
    }
}
