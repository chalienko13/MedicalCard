package com.chalienko.medcard.controller;

import com.chalienko.medcard.domain.model.Medicament;
import com.chalienko.medcard.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Controller
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;
    @RequestMapping(value = "/medicament", method = RequestMethod.GET)
    public String aboutPage(Model model) {
        model.addAttribute("medicaments", medicamentService.getAll());
        return "medicament";
    }

    @RequestMapping(value = "/medicament", method = RequestMethod.POST)
    public String addMedicament(String title, String comments) {
        medicamentService.addMedicament(new Medicament(title,comments));
        return "redirect:medicament";
    }
}
