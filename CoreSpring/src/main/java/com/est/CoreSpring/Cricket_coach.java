package com.est.CoreSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cricket_coach  implements Coach{
    public Cricket_coach(){
        System.out.println("inside CricketCoach");
    }
    @Override
    public String getCoach() {
        return "Batting";
    }
}
