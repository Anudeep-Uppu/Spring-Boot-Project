package com.Anudeep.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage()
    {
        //return "plain-login";
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        //return "plain-login";
        return "access-denied";
    }
}
