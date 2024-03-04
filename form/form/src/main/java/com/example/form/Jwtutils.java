package com.example.form;

import io.jsonwebtoken.*;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Principal;
import java.util.Date;

import static com.example.form.Constants.expiry;
import static com.example.form.Constants.milisec;

@Component
public class Jwtutils {


    private  String secret;
    private Constants constants;

    public Jwtutils(@Value("${token.secret}") String secret, Constants constant) {
        this.secret=secret;
        this.constants=constant;
    }

    public String jwtGenerator(Principal principal){
        System.out.println("Inside generator");
        //long milisec=System.currentTimeMillis();
        //long expiry=(milisec+60*60)*1000;
        Date issuedAt=new Date(Constants.milisec);
        Date expiryAt=new Date(Constants.expiry*1000);


        System.out.println("after date");
        Claims claims= Jwts.claims()
                .setId(principal.getName())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);
                ;
        System.out.println("After CLaims");
        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    public void verify(String Token) throws Exception {
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), sa.getJcaName());
        try{
            System.out.println(secret);
        Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(Token)
                ;


        } catch (Exception e) {
            throw new Exception("Could not verify JWT token integrity! \n"+e.getMessage());
        }
        System.out.println("Valid");


    }

}
