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
public class AdminRegistersController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registers", method = RequestMethod.GET)
    public ModelAndView registers() {
        ModelAndView modelAndView = new ModelAndView("admin/registers");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("registers", userService.getAllRegisters());
        return modelAndView;
    }


    @RequestMapping(value = "/registers", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addRegisters(String firstName, String secondName, String lastName, String username, String password) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        user.setUserName(username);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setLastName(lastName);
        Role register = new Role();
        register.setId(3L);
        register.setRole("ROLE_REGISTER");
        user.setRole(register);
        userService.insertUser(user);
        ModelAndView modelAndView = new ModelAndView("redirect:registers");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteRegisters", method = RequestMethod.GET)
    public @ResponseBody ModelAndView doctors(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: registers");
        userService.deleteUser(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("registers", userService.getAllRegisters());
        return modelAndView;
    }

}
