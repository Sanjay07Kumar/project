package com.examly.springapp.repositories;

import com.examly.springapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName); // ✅ Ensure this matches database column
}
