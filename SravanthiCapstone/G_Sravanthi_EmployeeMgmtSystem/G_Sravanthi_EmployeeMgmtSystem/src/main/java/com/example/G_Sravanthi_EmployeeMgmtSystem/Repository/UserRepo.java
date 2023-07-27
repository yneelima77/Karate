package com.example.G_Sravanthi_EmployeeMgmtSystem.Repository;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
