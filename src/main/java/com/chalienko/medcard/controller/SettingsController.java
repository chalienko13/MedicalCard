package com.chalienko.medcard.controller;

import com.chalienko.medcard.domain.model.Role;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.RoleService;
import com.chalienko.medcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
public class SettingsController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private static final long REGISTER_ROLE = 3;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String doctorPage() {
        return "settings";
    }


    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String addRegister(String firstName,String lastName, String secondName, String username, String password) {
        Role role = roleService.getRoleById(REGISTER_ROLE);
        userService.insertUser(new User(username, password, firstName, lastName, secondName,role,null ));
        return "settings";
    }
}
