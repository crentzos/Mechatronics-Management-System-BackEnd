package com.mechatronics.mechatronics_schedule_management.dao;


import com.mechatronics.mechatronics_schedule_management.entity.User;
import com.mechatronics.mechatronics_schedule_management.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByUsername(@Param("username") String name, Pageable pageable);
    Page<User> findByEmail(@Param("email") String email, Pageable pageable);
    Page<User> findByRoles(@Param("roles") Set<Role> roles, Pageable pageable);
    Page<User> findByAvailability(@Param("availability") boolean availability, Pageable pageable);

    @Query("select u from User u where u.id in :user_ids")
    List<User> findUserById(@Param("user_ids") List<Long> userIds);
}
