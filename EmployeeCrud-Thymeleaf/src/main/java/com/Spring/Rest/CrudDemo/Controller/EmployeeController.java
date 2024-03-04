package com.Spring.Rest.CrudDemo.Controller;

import com.Spring.Rest.CrudDemo.Service.EmployeeService;
import com.Spring.Rest.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {
   private  EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this. employeeService=employeeService;
    }
    //To Fetch the data from db and show it employee-list page
    @GetMapping("/employees")
    public String findAll(Model model){
        List<Employee> employees=employeeService.findAll();
        //System.out.println(employees);
        model.addAttribute("employees",employees);
        return "employee-list";

    }
    //To Redirect to the Employee form with model as employee object
    @GetMapping("/newemployee")
    public String NewEmployee(Model model){

        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";

    }
    //To Redirect to the Employe update form with model as employee object
    @GetMapping("/UpdateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int employeeid, Model model){


        Employee employee=employeeService.findById(employeeid);
        model.addAttribute("employee",employee);
        return "employee-update-form";

    }
    //To Create the data to db and show it in employee-list page
    @PostMapping("/newemployee")
    public String save(@ModelAttribute("employee") Employee employee)
    {
        employee.setId(0);
        Employee employee_result=employeeService.save(employee);
        System.out.println("post");
        return "redirect:/api/employees";
    }
    //To update the data to db and show it in employee-list page
    @PostMapping("/update-employee")
    public String updateById(@ModelAttribute("employee") Employee employee)
    {
        Employee employee_result=employeeService.save(employee);
        System.out.println("update");
        System.out.println(employee_result);
        return "redirect:/api/employees";
    }

    @GetMapping("/delete-employee")
    public String deleteById(@RequestParam("employeeId") int employeeid)
    {

        int id=employeeService.deleteById(employeeid);
        System.out.println("id "+id +"got deleted");
        return "redirect:/api/employees";
    }
}
