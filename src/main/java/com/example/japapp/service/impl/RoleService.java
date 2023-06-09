package com.example.japapp.service.impl;

import com.example.japapp.model.Role;
import com.example.japapp.model.User;
import com.example.japapp.repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    private final RolesRepository rolesRepository;

    public RoleService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public void setUserRole(User user) {
        this.setRole(user, "USER");
    }

    public void setAdminRole(User user) {
        this.setRole(user, "ADMIN");
    }

    public void setRole(User user, String roleName) {
        Role role = saveRole(roleName);

        if (user.getRoles().isEmpty()) {
            user.setRoles(Collections.singleton(role));
        } else {
            Set<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
        }
    }

    public Role saveRole(String name) {
        Optional<Role> userRole = rolesRepository.findByName(name);
        Role role = null;
        if (userRole.isEmpty()) {
            role = new Role(name);
            role = rolesRepository.save(role);
        }
        return role;
    }
}
