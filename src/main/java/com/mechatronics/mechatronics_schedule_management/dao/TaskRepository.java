package com.mechatronics.mechatronics_schedule_management.dao;

import com.mechatronics.mechatronics_schedule_management.entity.Task;
import com.mechatronics.mechatronics_schedule_management.enums.Role;
import com.mechatronics.mechatronics_schedule_management.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByTitle(@Param("title") String title, Pageable pageable);

    Page<Task> findByCreatedBy(@Param("createdBy") String createdBy, Pageable pageable);

    Page<Task> findByCreatedAtAfter(@Param("createdAt") LocalDateTime createdAt, Pageable pageable);

    Page<Task> findByRole(@Param("role") Role role, Pageable pageable);

    Page<Task> findByStatus(@Param("status") Status status, Pageable pageable);

    Page<Task> findByLocation(@Param("location") String location, Pageable pageable);

    // will discuss if needed
    @Query("select t from Task t where t.id in :task_ids")
    List<Task> findTaskById(@Param("task_ids") List<Long> taskIds);
}
