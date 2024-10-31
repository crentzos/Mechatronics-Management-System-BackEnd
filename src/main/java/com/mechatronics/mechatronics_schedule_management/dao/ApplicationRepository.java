package com.mechatronics.mechatronics_schedule_management.dao;

import com.mechatronics.mechatronics_schedule_management.entity.Application;
import com.mechatronics.mechatronics_schedule_management.entity.Task;
import com.mechatronics.mechatronics_schedule_management.entity.User;
import com.mechatronics.mechatronics_schedule_management.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findByStatus(@Param("status") Set<Status> status, Pageable pageable);
    Page<Application> findByUser(@Param("user") User user, Pageable pageable);
    Page<Application> findByTask(@Param("task") Task task, Pageable pageable);
    Page<Application> findByApplicationDate(@Param("applicationDate")LocalDateTime applicationDate, Pageable pageable);

    // will discuss if needed
    @Query("select a from Application a where a.id in :application_ids")
    List<Application> findApplicationById(@Param("application_ids") List<Long> applicationIds);
}
