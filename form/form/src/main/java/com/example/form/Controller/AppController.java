package com.example.form.Controller;

import com.example.form.Lov.Current_project;
import com.example.form.entity.EmployeeDetails;
import com.example.form.entity.LeaveDetails;
import com.example.form.entity.Login;
import com.example.form.Interceptor.Jwtutils;
import com.example.form.service.AppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("app")
public class AppController {

    private AppService appService;
    @Autowired
    private Jwtutils jwtutils;
    @Autowired
    public AppController(AppService appService, Jwtutils jwtutils){
        this.appService = appService;
        this.jwtutils=jwtutils;

    }
    public  String Token;
    @GetMapping("leaves")
    public String findAll(Model model, Principal principal) throws Exception {

         Token=jwtutils.jwtGenerator(principal);
         try{
         jwtutils.verify(Token);}
         catch(Exception e){
             return "accessdenied";
         }
        System.out.println("Token is : "+Token);
        List<LeaveDetails> leave=appService.findAll();
        model.addAttribute("leave",leave);
        System.out.println(principal.getName());

        return "leavelist";
    }
    @GetMapping("leave")
    public LeaveDetails findById(@RequestParam("id") int id){
        return appService.findById(id);
    }

    @PostMapping("leave")
    public String save(@Valid @ModelAttribute("leave") LeaveDetails leave, BindingResult bindingResult) throws Exception {
        try{
            jwtutils.verify(Token);}
        catch(Exception e){
            return "accessdenied";
        }
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "leaveForm";
        }
        leave.setStatus("Pending Approval");
        LeaveDetails result=appService.save(leave);
        return "redirect:/app/leaves";
    }
    @GetMapping("leave/update")
    public String update(@RequestParam("id")int id) throws Exception {
        try{
            jwtutils.verify(Token);}
        catch(Exception e){
            return "accessdenied";
        }
        LeaveDetails leave=appService.findById(id);
        if(leave.getStatus().equals("Pending Approval"));
        {
            leave.setStatus("Approved");
            System.out.println(appService.update(leave));
        }
        return "redirect:/app/leaves";
    }

    @DeleteMapping("leave/{id}")
    public String delete(@PathVariable int id){
        return appService.delete(id);
    }

    ///Employee Controller

    @GetMapping("employees")
    public  String employeeFindAll(Model model) throws Exception {
        try{
            jwtutils.verify(Token);}
        catch(Exception e){
            return "accessdenied";
        }
        List<EmployeeDetails>employee=appService.employeeFindAll();
        model.addAttribute("employee",employee);
        return "EmployeeList";
    }

    @GetMapping("employee")
    public String employeeFindById(@RequestParam("id") int id,Model model) throws Exception {
        try{
            jwtutils.verify(Token);}
        catch(Exception e){
            return "accessdenied";
        }
        EmployeeDetails employee=appService.employeeFindById(id);
        System.out.println(employee);
        System.out.println(id);
        model.addAttribute("employee",employee);
        return "EmployeeList";
    }


    @PostMapping("employee")
    public String save( @ModelAttribute("employee") EmployeeDetails employeeDetails ){
        try{
            jwtutils.verify(Token);}
        catch(Exception e){
            return "accessdenied";
        }
        appService.employeeSave(employeeDetails);
        return "redirect:/app/employees";
    }

    @GetMapping("employee/new")
    public String employeePageRedirect(Model model){
        EmployeeDetails employee=new EmployeeDetails();

        model.addAttribute("employee",employee);
        return "employeeForm";
    }
    @GetMapping("leave/new")
    public String leavePageRedirect(Model model){
        LeaveDetails leave=new LeaveDetails();
        leave.setStatus("New");
        List<Current_project> currentProject=appService.getCurrProjValues();
        model.addAttribute("leave",leave);
        model.addAttribute("currentProject",currentProject);
        return "leaveForm";
    }
/*
    @GetMapping("leave/update")
    public String leaveupdatePageRedirect(@RequestParam("id") int id, Model model){

        LeaveDetails leave=appService.findById(id);
       // List<Current_project> currentProject=appService.getCurrProjValues();
        model.addAttribute("leave",leave);
       // model.addAttribute("currentProject",currentProject);
        if(leave.getStatus().equals("Pending Approval"))
            leave.setStatus("Approved");
        return "approveForm";
    }
*/

    @GetMapping("/showmyloginpage")
    public String logIn(Model model)
    {

        Login login=new Login();
        model.addAttribute("Login",login);

        return "login";
    }
    @GetMapping("/accessdenied")
    public String accesdenied(){
        return "accessdenied";
    }
}
