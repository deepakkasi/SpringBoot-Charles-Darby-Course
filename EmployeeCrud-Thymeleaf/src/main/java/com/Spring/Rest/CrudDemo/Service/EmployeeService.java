package com.Spring.Rest.CrudDemo.Service;

import com.Spring.Rest.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public Employee updateById(Employee employee);
    public int deleteById(int id);
}
