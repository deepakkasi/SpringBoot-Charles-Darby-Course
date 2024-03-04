package com.est.CoreSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CoachImpl implements Coach{
    public CoachImpl(){
        System.out.println("inside Coachimpl");

    }
    @Override
    public String getCoach() {

        return "20 Pushups now";
    }
}
