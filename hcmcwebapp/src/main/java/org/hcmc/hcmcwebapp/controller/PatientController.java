package org.hcmc.hcmcwebapp.controller;

import org.hcmc.hcmcwebapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(value = {"/patients"})
    public ModelAndView displayListOfPatients() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patientService.getPatients());
        modelAndView.setViewName("patients");
        return modelAndView;
    }

    @GetMapping(value = {"/patients/elderly"})
    public ModelAndView displayListOfElderlyPatients() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patientService.getElderlyPatients());
        modelAndView.setViewName("patients");
        return modelAndView;
    }

//    public String displayListOfPatients2(Model model) {
//        model.addAttribute("patients", patientService.getPatients());
//        return "patients";
//    }
}
