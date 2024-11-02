package com.mechatronics.mechatronics_schedule_management.entity;

import com.mechatronics.mechatronics_schedule_management.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime applicationDate;
    @Enumerated(EnumType.STRING)
    private Set<Status> status;

    @OneToMany
    private List<Task> task;
    @ManyToOne
    private User user;

    public Application(LocalDateTime applicationDate, Set<Status> status, List<Task> task, User user) {
        this.applicationDate = applicationDate;
        this.status = status;
        this.task = task;
        this.user = user;
    }
}

