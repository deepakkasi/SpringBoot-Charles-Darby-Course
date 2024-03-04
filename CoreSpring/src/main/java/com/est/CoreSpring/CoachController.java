package com.est.CoreSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
private Coach mycoach;
@Autowired
public CoachController(@Qualifier("aquatic") Coach thecoach){
    mycoach=thecoach;
}
    @GetMapping("/getcoach")

    public String getcoach(){
        return mycoach.getCoach();
    }
}
