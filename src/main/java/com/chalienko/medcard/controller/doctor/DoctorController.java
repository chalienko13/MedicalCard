package com.chalienko.medcard.controller.doctor;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.PatientService;
import com.chalienko.medcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView doctorPage() {
        ModelAndView modelAndView = new ModelAndView("doctor/doctor");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = null;
        if (auth.getPrincipal() instanceof UserDetails) {
            userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        User user = userService.getByUserName(userDetails.getUsername());
        modelAndView.addObject("patients",patientService.getPatientsByDoctorId(user.getId()));
        return modelAndView;
    }
}
