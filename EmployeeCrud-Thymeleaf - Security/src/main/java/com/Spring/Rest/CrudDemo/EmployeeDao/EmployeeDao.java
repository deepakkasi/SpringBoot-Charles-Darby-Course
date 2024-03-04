package com.Spring.Rest.CrudDemo.EmployeeDao;

import com.Spring.Rest.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int id);


    Employee save(Employee employee);

    public Employee updateById(Employee employee);
    public int deleteById(int id);
}
