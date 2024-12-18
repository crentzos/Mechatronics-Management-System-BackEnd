package com.mechatronics.mechatronics_schedule_management.entity;

import com.mechatronics.mechatronics_schedule_management.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "createdBy")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "user")
    private List<Application> applications;

    public User(String username, Set<Role> roles, boolean availability, String email, Set<Task> tasks) {
        this.username = username;
        this.roles = roles;
        this.availability = availability;
        this.email = email;
        this.tasks = tasks;
    }
}
