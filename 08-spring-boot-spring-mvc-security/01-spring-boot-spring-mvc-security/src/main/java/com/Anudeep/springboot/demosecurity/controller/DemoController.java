package com.Anudeep.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome()
    {
        // This is the view name
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders()
    {
        // This is the view name
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems()
    {
        // This is the view name
        return "systems";
    }
}
