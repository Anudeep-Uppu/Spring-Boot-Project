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

    // expose a new endpoint for work out

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k!!";
    }

    // expose a new endpoint for fortune

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day!";
    }
}
