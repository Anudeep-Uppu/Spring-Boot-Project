package com.Anudeep.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // --> Now this annotation makes the class as a spring bean and is ready for dependency injection
public class CricketCoach implements Coach{

    public CricketCoach()
    {
        System.out.println("In constructor : " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!. Yeaaaaah";
    }
}
