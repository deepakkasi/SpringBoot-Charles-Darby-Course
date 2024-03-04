package com.thymleaf.thymeleaf.contollerClass;

import com.thymleaf.thymeleaf.modal.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.messageresolver.IMessageResolver;

import java.util.List;


@Controller
public class controller {
    @Value("${countries}")
    private List countries;
    @Value("${language}")
    private List language;
    @Value("${food}")
    private List food;
    @GetMapping("/student-form")
    public String studentForm(Model model){


    Student theStudent=new Student();
    model.addAttribute("student",theStudent);
    model.addAttribute("countries",countries);
        model.addAttribute("language",language);
        model.addAttribute("food",food);
    return "student-form";

    }

    @PostMapping("/student-confirmed")
    public String processFormv2(@ModelAttribute("student") Student theStudent)
    {
        System.out.println("the Student is " +theStudent.getFirstName()+"  "+ theStudent.getLastName());
        System.out.println(theStudent.getFood());
        // String name=request.getParameter("Name");
       return "student-confirmed";
    }
}


