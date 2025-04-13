package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Create a new role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get a role by ID
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
    }

    // Update a role
    public Role updateRole(Long id, Role updatedRole) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
        role.setRoleName(updatedRole.getRoleName());
        role.setDescription(updatedRole.getDescription());
        return roleRepository.save(role);
    }

    // Delete a role by ID
    public boolean deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
