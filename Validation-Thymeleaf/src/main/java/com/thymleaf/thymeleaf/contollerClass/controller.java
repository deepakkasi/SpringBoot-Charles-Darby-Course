package com.thymleaf.thymeleaf.contollerClass;

import com.thymleaf.thymeleaf.modal.Student;
import jakarta.servlet.http.HttpServletRequest;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.messageresolver.IMessageResolver;

import java.util.List;


@Controller
public class controller {

    @GetMapping("/student-form")
    public String studentForm(Model model){


    Student theStudent=new Student();
    model.addAttribute("student",theStudent);
    return "student-form";

    }

    @PostMapping("/student-confirmed")
    public String processFormv2(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult)

    {
        System.out.println(bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.hasErrors());
            return "student-form";
        }
        System.out.println("lastName : |"+theStudent.getLastName()+"|");
        System.out.println("the Student is " +theStudent.getFirstName()+"  "+ theStudent.getLastName());
        // String name=request.getParameter("Name");
       return "student-confirmed";
    }

    @InitBinder
    public void springBinder(WebDataBinder dataBinder){
        StringTrimmerEditor trim=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,trim);
    }
}


