package com.chalienko.medcard.controller.doctor;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Patient;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.PatientService;
import com.chalienko.medcard.service.UserService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
@RequestMapping(value = "/doctor")
public class PatientsDoctorController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/patientdoctor", method = RequestMethod.GET)
    public ModelAndView doctorPage(HttpServletResponse response) throws DocumentException {

//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", String.format("inline; filename=ApplicationForm.pdf"));
//        Document document = new Document();
//        PdfWriter writer = null;
//        try {
//            writer = PdfWriter.getInstance(document, response.getOutputStream());
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Paragraph p = new Paragraph("asdasdad");
//        document.open();
//        document.add(p);
//        document.close();
//        writer.close();


        ModelAndView model = new ModelAndView("doctor/patientdoctor");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = null;
        if (auth.getPrincipal() instanceof UserDetails) {
            userDetails = (CustomUserDetails) auth.getPrincipal();
            model.addObject("user", userDetails);
            User user = userService.getByUserName(userDetails.getUsername());
            List<Patient> patients = patientService.getPatientsByDoctorId(user.getId());
            model.addObject("patients", patients);
        } else {
            model.addObject("user", userDetails);
            User user = userService.getByUserName(auth.getPrincipal().toString());
            List<Patient> patients = patientService.getPatientsByDoctorId(user.getId());
            model.addObject("patients", patients);
        }
        return model;
    }


}
