package com.chalienko.medcard.controller.admin;

import com.chalienko.medcard.config.CustomUserDetails;
import com.chalienko.medcard.domain.model.Department;
import com.chalienko.medcard.service.DepartmentService;
import com.chalienko.medcard.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
public class AdminDepartmentController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView doctors(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: department");
        departmentService.delete(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("departments", departmentService.getAllDepartments());
        return modelAndView;
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ModelAndView department() {
        ModelAndView modelAndView = new ModelAndView("admin/department");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("departments", departmentService.getAllDepartments());
        return modelAndView;
    }

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public ModelAndView addDepartment(String title) {
        Department department = new Department();
        department.setTitle(title);
        departmentService.insert(department);
        ModelAndView modelAndView = new ModelAndView("redirect:department");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            modelAndView.addObject("user", userDetails);
        }
        modelAndView.addObject("departments", departmentService.getAllDepartments());
        return modelAndView;
    }
}
