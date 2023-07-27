package com.example.G_Sravanthi_EmployeeMgmtSystem.Repository;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}