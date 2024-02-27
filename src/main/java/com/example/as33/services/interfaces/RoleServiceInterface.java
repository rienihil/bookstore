package com.example.as33.services.interfaces;

import com.example.as33.models.Role;

import java.util.List;

public interface RoleServiceInterface {
    List<Role> getAllRoles();
    Role createRole(Role role);
    void deleteRoleById(int id);
}
