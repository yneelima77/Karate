package com.example.G_Sravanthi_EmployeeMgmtSystem.Repository;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Long> {

}
