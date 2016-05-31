package com.chalienko.medcard.controller.doctor;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Patient;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.PatientService;
import com.chalienko.medcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
@RequestMapping(value = "/doctor")
public class MapController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map() {
        return "doctor/map";
    }

    @RequestMapping(value = "/mapAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Patient> mapAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = null;
        if (auth.getPrincipal() instanceof UserDetails) {
            userDetails = (CustomUserDetails) auth.getPrincipal();
        }
        User user = userService.getByUserName(userDetails.getUsername());
        List<Patient> patients = patientService.getPatientsByDoctorId(user.getId());
        return patients;
    }
}
