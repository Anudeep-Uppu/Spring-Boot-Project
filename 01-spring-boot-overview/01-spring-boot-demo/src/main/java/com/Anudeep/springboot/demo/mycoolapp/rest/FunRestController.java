package com.Anudeep.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This will set up the rest controller
public class FunRestController {

    //expose "/" that returns hello world.
    @GetMapping("/") // This will handle the HTTP GET requests
    public String sayHello()
    {
        return "Hello World!!";
    }
}
