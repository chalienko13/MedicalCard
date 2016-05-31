package com.chalienko.medcard.controller.admin;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Analises;
import com.chalienko.medcard.domain.model.Department;
import com.chalienko.medcard.service.AnalisesService;
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
public class AdminAnalisesController {

    @Autowired
    private AnalisesService analisesService;
    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit() {
        return "index";
    }

    @RequestMapping(value = "/deleteAnalises", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView doctors(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: analises");
        analisesService.delete(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("analises", analisesService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addAnalises", method = RequestMethod.POST)
    public ModelAndView addDepartment(String title) {
        Analises analises = new Analises();
        analises.setAnalisesType(title);
        analisesService.insert(analises);
        ModelAndView modelAndView = new ModelAndView("redirect:analises");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("analises", analisesService.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/analises", method = RequestMethod.GET)
    public ModelAndView analises() {
        ModelAndView modelAndView = new ModelAndView("admin/analises");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("analises",analisesService.getAll());
        return modelAndView;
    }

}
