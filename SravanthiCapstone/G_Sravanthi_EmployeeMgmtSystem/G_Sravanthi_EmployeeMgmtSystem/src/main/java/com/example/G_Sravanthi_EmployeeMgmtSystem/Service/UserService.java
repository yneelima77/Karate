package com.example.G_Sravanthi_EmployeeMgmtSystem.Service;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.User;
import com.example.G_Sravanthi_EmployeeMgmtSystem.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
