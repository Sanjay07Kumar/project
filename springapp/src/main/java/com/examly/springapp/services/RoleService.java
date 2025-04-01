package com.examly.springapp.services;

import com.examly.springapp.entities.Role;
import com.examly.springapp.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // ✅ Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    // ✅ Add a new role (if not exists)
    public Role addRole(String roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseGet(() -> roleRepository.save(new Role(roleName)));
    }
    public Optional<Role> getRoleByName(String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        if (role.isEmpty()) {
            System.out.println("⚠️ Role not found: " + roleName);
        }
        return role;
    
    }   
}
