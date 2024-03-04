package com.example.Spring.Before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {

    @Before("execution(public void addAccount())")
    public void beforAdviceFunction(){
        System.out.println("Inside beforeAdice function");
    }

}
