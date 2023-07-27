package com.example.G_Sravanthi_EmployeeMgmtSystem.Service;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.Emp;
import com.example.G_Sravanthi_EmployeeMgmtSystem.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;
    public List<Emp> getAllEmployees() {
        return empRepo.findAll();
    }

    public void saveEmployee(Emp employee) {
        this.empRepo.save(employee);
    }

    public Emp getEmployeeById(long id) {
        Optional<Emp> optional = empRepo.findById(id);
        Emp employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }


    public void deleteEmployeeById(long id) {
        this.empRepo.deleteById(id);
    }
}
