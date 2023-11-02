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

    @PostConstruct // define the init method
    public void init() // --> This method name could be anything
    {
        System.out.println("Method init() : " + getClass().getSimpleName());
    }

    @PreDestroy // Do the cleanup activity before bean destruction
    public void destroy()
    {
        System.out.println("Method destroy() : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!. Yeaaaaah";
    }
}
