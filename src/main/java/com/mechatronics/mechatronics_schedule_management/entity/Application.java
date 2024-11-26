package com.mechatronics.mechatronics_schedule_management.entity;

import com.mechatronics.mechatronics_schedule_management.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "application_date")
    private LocalDateTime applicationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Application(LocalDateTime applicationDate, Status status, Task task, User user) {
        this.applicationDate = applicationDate;
        this.status = status;
        this.task = task;
        this.user = user;
    }
}

