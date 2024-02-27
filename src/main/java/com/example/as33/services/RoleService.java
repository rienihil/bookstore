package com.example.as33.services;

import com.example.as33.models.Role;
import com.example.as33.repositories.BookRepositoryInterface;
import com.example.as33.repositories.RoleRepositoryInterface;
import com.example.as33.services.interfaces.RoleServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceInterface {
    private final RoleRepositoryInterface repo;

    public RoleService(RoleRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Role> getAllRoles() {
        return repo.findAll(Sort.by("id"));
    }

    @Override
    public Role createRole(Role role) {
        return repo.saveAndFlush(role);
    }

    @Override
    public void deleteRoleById(int id) {
        repo.deleteById(id);
    }
}
