package com.example.as33.controllers;

import com.example.as33.models.Role;
import com.example.as33.services.interfaces.RoleServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_roles")
public class RoleController {
    private final RoleServiceInterface service;

    public RoleController(RoleServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return service.getAllRoles();
    }

    @PostMapping("/")
    public Role createRole(@RequestBody Role role){
        return service.createRole(role);
    }
    @DeleteMapping("/{role_id}")
    public void deleteRole(@PathVariable("role_id") int id){
        service.deleteRoleById(id);
    }
}
