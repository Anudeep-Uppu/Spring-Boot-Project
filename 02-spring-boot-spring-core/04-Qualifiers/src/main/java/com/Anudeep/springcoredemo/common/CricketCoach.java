package com.Anudeep.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component // --> Now this annotation makes the class as a spring bean and is ready for dependency injection
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!. Yeaaaaah";
    }
}
