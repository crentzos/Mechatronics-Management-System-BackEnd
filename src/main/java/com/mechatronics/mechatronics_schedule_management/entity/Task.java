package com.mechatronics.mechatronics_schedule_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date postedDate;
    private Date expirationDate;
    private int availablePositions;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;


    public Task(String title, String description, Date postedDate, Date expirationDate, int availablePositions) {
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.availablePositions = availablePositions;
    }
}
