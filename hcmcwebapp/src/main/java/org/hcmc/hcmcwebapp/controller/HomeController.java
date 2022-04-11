package org.hcmc.hcmcwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "hcmc/home"})
    public String home() {
        return "index";
    }
}
