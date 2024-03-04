package com.est.CoreSpring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class TrackCoach implements Coach{
    TrackCoach(){
        System.out.println("inside TrackCoach");
    }
    @Override
    public String getCoach() {
        return "Batting";
    }
}

