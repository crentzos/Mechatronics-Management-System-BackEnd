package com.mechatronics.mechatronics_schedule_management.entity;

package com.mechatronics.mechatronics_schedule_management.enums;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private String name;
    private Set<Permission> permissions;

    // Constructor
    public Role(String name) {
        this.name = name;
        this.permissions = new HashSet<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    // Override toString for easy debugging
    @Override
    public String toString() {
        return name + " " + permissions;
    }
}

