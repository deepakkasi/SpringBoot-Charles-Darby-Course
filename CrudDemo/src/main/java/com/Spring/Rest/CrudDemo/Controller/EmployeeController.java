package com.Spring.Rest.CrudDemo.Controller;

import com.Spring.Rest.CrudDemo.Exception.EmployeeNotFoundException;
import com.Spring.Rest.CrudDemo.Service.EmployeeService;
import com.Spring.Rest.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
   private  EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this. employeeService=employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee findById(@PathVariable int employeeid){
        Employee result=employeeService.findById(employeeid);

        if(result==null){
            throw    new EmployeeNotFoundException("Employee id "+employeeid+" not found ");


        }
        return result;
    }
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee)
    {
        employee.setId(0);
        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateById(@RequestBody Employee employee)

    {

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteById(@PathVariable int employeeid)
    {

        Employee result=employeeService.findById(employeeid);

        if(result==null){
            throw  new EmployeeNotFoundException("Employee id "+employeeid+" not found to delete");

        }
        int id=employeeService.deleteById(employeeid);
        return "Employee "+id+" deleted sucessfully";
    }


}
