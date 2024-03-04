package com.example.form;

import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static long milisec=System.currentTimeMillis();
    public static long expiry=milisec+60*60;
}
