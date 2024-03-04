package com.est.CoreSpring;

import org.springframework.stereotype.Component;


public class SwimCoach  implements Coach{
    public SwimCoach(){
        System.out.println("inside Swimcoach");
    }
    @Override
    public String getCoach() {
        return "Batting";
    }
}