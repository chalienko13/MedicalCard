package com.chalienko.medcard.controller.doctor;

import com.chalienko.medcard.domain.model.*;
import com.chalienko.medcard.service.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private AnalisesService analisesService;

    private static final long DOCTOR_ID = 1l;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    @ResponseBody
    public String aboutPage(@RequestParam Long id) {
        Patient patient = patientService.getPatientById(id);
        return patient.getLastName();
    }

    @RequestMapping(value = "/addAnalises", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addAnalises(@RequestParam Long id, String analises, HttpServletResponse response) {
        BaseFont times = null;
        String[] analisesString = analises.split(",");
        List<Long> idAnalises = new ArrayList<>();
        List<Analises> pAnalises = new ArrayList<>();
        for (String idAnalis : analisesString) {
            idAnalises.add(Long.parseLong(idAnalis));
        }
        for (Long idAn : idAnalises) {
            pAnalises.add(analisesService.getById(idAn));
        }
        try {
            times = BaseFont.createFont("c:/windows/fonts/times.ttf","cp1251",BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format("inline; filename=ApplicationForm.pdf"));
        Document document = new Document();
        PdfWriter writer = null;
        try {
            writer = PdfWriter.getInstance(document, response.getOutputStream());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            document.open();
            Patient patient = patientService.getPatientById(id);
            User doctor = patient.getDoctor();
            String pdfPatient = "Пацієнт: " + patient.getFirstName() + " " + patient.getLastName();
            Paragraph pDoctor = new Paragraph("Лікарь: " + doctor.getFirstName() + " " + doctor.getLastName(),
                    new Font(times,14));
            document.add(pDoctor);
            Paragraph pPatient = new Paragraph(pdfPatient, new Font(times, 14));

            String analisString = "     ";
            int count = 1;
            for (Analises analises1 : pAnalises) {
                analisString += " " + count +". " + analises1.getAnalisesType() + " \n      ";
                count++;
            }
            Paragraph parAnalises = new Paragraph(analisString, new Font(times, 11));
            Paragraph a = new Paragraph("Необхідні аналізи для проходження: \n",  new Font(times, 12));
            document.add(pPatient);
            document.add(a);
            document.add(parAnalises);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        writer.close();
        ModelAndView modelAndView = new ModelAndView("redirect: patients?id=" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView aboutPatient(@RequestParam("id") Long id) {
        Patient patient = patientService.getPatientById(id);
        ModelAndView modelAndView = new ModelAndView("doctor/patient");
        modelAndView.addObject("patient", patient);
        modelAndView.addObject("medicaments", medicamentService.getAll());
        modelAndView.addObject("analises", analisesService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String addExamination(@RequestParam Long id, String medicaments, String diagnose) {
        String[] medicament = {};
        if (medicaments != null) {
            medicament = medicaments.split(",");
        }
        List<Medicament> medicamentList = new ArrayList<>();
        for (String med : medicament) {
            medicamentList.add(medicamentService.getByTitle(med));
        }
        User user = userService.getUserById(DOCTOR_ID);
        Patient patient = patientService.getPatientById(id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Examination examination = new Examination(user, patient, timestamp, diagnose, medicamentList);
        examinationService.save(examination);
        return "redirect:patient?id=" + id;
    }

}
