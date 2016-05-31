package com.chalienko.medcard.controller.admin;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Department;
import com.chalienko.medcard.domain.model.Role;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.DepartmentService;
import com.chalienko.medcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminDoctrosController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/doctors", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addDoctor(String department, String firstName, String secondName, String lastName, String username, String password) {
        Department department1 = departmentService.getById(Long.parseLong(department));
        User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        user.setUserName(username);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setLastName(lastName);
        user.setDepartment(department1);
        Role doctor = new Role();
        doctor.setId(4L);
        doctor.setRole("ROLE_DOCTOR");
        user.setRole(doctor);
        userService.insertUser(user);
        ModelAndView modelAndView = new ModelAndView("redirect:doctors");
        return modelAndView;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView doctors() {
        ModelAndView modelAndView = new ModelAndView("admin/doctors");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("departments", departmentService.getAllDepartments());
        modelAndView.addObject("doctors", userService.getAllDoctors());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteDoctor", method = RequestMethod.GET)
    public @ResponseBody ModelAndView doctors(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: doctors");
        System.out.println("ID: " + id);
        userService.deleteUser(id);
        System.out.println("After delete");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        System.out.println( userService.getAllDoctors());
        modelAndView.addObject("doctors", userService.getAllDoctors());
        return modelAndView;
    }

}
