package com.chalienko.medcard.controller;

import com.chalienko.medcard.config.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class DoctorTest {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String doctorPage(ModelMap model) {
        System.out.println("Model" + model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails){
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            System.out.println(userDetails.getFirstName());

        }else {
            System.out.println(auth.toString());
        }
        System.out.println(auth.getName());
        return "admin/main";
    }
}
