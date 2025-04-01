package com.examly.springapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name",unique = true, nullable = false)
    private String roleName; // Changed to String

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}