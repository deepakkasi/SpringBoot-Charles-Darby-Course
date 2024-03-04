package com.est.CoreSpring.Config;

import com.est.CoreSpring.Coach;
import com.est.CoreSpring.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class SwimCoachConfig {
    @Bean("aquatic")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
