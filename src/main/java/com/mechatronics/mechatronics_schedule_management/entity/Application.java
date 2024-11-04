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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "application_date")
    private LocalDateTime applicationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Application(LocalDateTime applicationDate, Status status, List<Task> tasks, User user) {
        this.applicationDate = applicationDate;
        this.status = status;
        this.tasks = tasks;
        this.user = user;
    }
}

