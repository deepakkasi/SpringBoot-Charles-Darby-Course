package com.Spring.Rest.CrudDemo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("/employees")
    public String employee(){

        return "employee-form";

    }
    @GetMapping("/manager")
    public String manager(){

        return "manager-form";

    }
    @GetMapping("/admin")
    public String admin(){

        return "admin-form";

    }
    @GetMapping("/showMyLoginPage")
    public String login(){
        return "fancy-login";
    }
    @GetMapping("/accessdenied")
    public String accesdenied(){
        return "accessdenied";
    }
}
