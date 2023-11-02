package com.Anudeep.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${coach.name}")
    private String coach_name;

    @Value("${team.name}")
    private String team_name;

    // Expose new endpoint for team info.

    @GetMapping("/teaminfo")
    public String getTeamInfo()
    {
        return "Team name is : " + team_name + " Coach name is : " + coach_name;
    }
}
