package com.chalienko.medcard.controller.register;

import com.chalienko.medcard.domain.model.Patient;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.PatientService;
import com.chalienko.medcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
public class RegisterController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView("register/register");
        modelAndView.addObject("doctors", userService.getAllDoctors());
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registeredPatient(String lastName, String firstName, String secondName, String age,
                                    String sex, String address, String phone, String numberAK,
                                    String height, String weight,Long doctor) {
        patientService.insertPatient(new Patient(firstName,secondName,lastName,Integer.parseInt(age),
        sex,address,phone,numberAK,null,Integer.parseInt(height),Integer.parseInt(weight),
                userService.getUserById(doctor),null));
        return "redirect:/register";
    }
}
