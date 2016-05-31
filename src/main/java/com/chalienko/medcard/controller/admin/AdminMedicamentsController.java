package com.chalienko.medcard.controller.admin;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Department;
import com.chalienko.medcard.domain.model.Medicament;
import com.chalienko.medcard.domain.model.Role;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class AdminMedicamentsController {
    @Autowired
    private MedicamentService medicamentService;

    @RequestMapping(value = "/medicaments", method = RequestMethod.GET)
    public ModelAndView medicaments() {
        ModelAndView modelAndView = new ModelAndView("admin/medicaments");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("medicaments", medicamentService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMedicament", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView doctors(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: medicaments");
        medicamentService.delete(id);
        return modelAndView;
    }

    @RequestMapping(value = "/medicaments", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addMedicament(String title, String comment) {
        Medicament medicament = new Medicament();
        medicament.setTitle(title);
        medicament.setComments(comment);
        medicamentService.addMedicament(medicament);

        return new ModelAndView("redirect:medicaments");
    }
}
