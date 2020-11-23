package com.example.productManager.Repositories;

import com.example.productManager.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByRole(String role);
}
