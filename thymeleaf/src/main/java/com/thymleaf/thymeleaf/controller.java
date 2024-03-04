package com.thymleaf.thymeleaf;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.messageresolver.IMessageResolver;

@Controller
public class controller {
@RequestMapping("/loginForm")
    public String loginform(){
        return "helloworld";
    }
    @RequestMapping("/processForm")
    public String processForm(){
    return "hello-form";
    }
    @RequestMapping("/processFormv2")
    public String processFormv2(@RequestParam("Name") String thename, Model modal ){
       // String name=request.getParameter("Name");
        String name=thename;
        name=name.toUpperCase();
        String result="Yo "+name;
        modal.addAttribute("message",result);
        return "Modal";
    }
}


