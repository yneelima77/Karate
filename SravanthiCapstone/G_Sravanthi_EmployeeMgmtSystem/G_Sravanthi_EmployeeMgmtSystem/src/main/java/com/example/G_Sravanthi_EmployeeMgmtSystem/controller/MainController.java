package com.example.G_Sravanthi_EmployeeMgmtSystem.controller;

import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.Emp;
import com.example.G_Sravanthi_EmployeeMgmtSystem.Model.User;
import com.example.G_Sravanthi_EmployeeMgmtSystem.Service.EmpService;
import com.example.G_Sravanthi_EmployeeMgmtSystem.Service.UserService;
import com.example.G_Sravanthi_EmployeeMgmtSystem.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SuppressWarnings("ALL")
@Controller
public class MainController {
    private UserService userService;
    private EmpService empService;
    public MainController(UserService userService,EmpService empService) {
        this.userService = userService;
        this.empService = empService;
    }

    @GetMapping("/index")
    public String viewHomePage(Model model) {
        //model.addAttribute("listEmployees", empService.getAllEmployees());
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    /*Employee Handlers*/

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Emp employee = new Emp();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Emp employee) {
        // save employee to database
        empService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Emp employee = empService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.empService.deleteEmployeeById(id);
        return "redirect:/";
    }



}
