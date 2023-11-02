package com.Anudeep.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Anudeep.springcoredemo.common.Coach;
import com.Anudeep.springcoredemo.common.SwimCoach;


@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() // --> Bean ID is same as method name
    {
        return new SwimCoach();
    }
}
