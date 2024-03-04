package com.est.BasicSpring.FunController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicDev {

    @GetMapping("/Team")
    public String team(){
        return "hello everyone";
    }

    @Value("${name}")
    public String Name;
    @Value("${age}")
    public String Age;
    @GetMapping("/group")
    public String roup(){
        return "Name is "+Name+"age is "+Age;
    }
}
