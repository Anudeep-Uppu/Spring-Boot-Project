package com.Anudeep.springcoredemo.rest;

import com.Anudeep.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theAnotherCoach)
   {
       System.out.println("In constructor : " + getClass().getName());
       myCoach = theCoach;
       anotherCoach = theAnotherCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/compare")
    public String compareObjects()
    {
        return "Comparing both the references/beans myCoach == theAnotherCoach : " + (myCoach == anotherCoach);
    }
}
