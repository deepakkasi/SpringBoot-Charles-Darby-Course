package com.example.form.dao;

import com.example.form.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDao {
    List<EmployeeDetails> findAll();

    EmployeeDetails employeeSave(EmployeeDetails employeeDetails);
    public EmployeeDetails employeeFindById(int id);
}
