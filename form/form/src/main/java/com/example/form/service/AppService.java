package com.example.form.service;


import com.example.form.Lov.Current_project;
import com.example.form.entity.EmployeeDetails;
import com.example.form.entity.LeaveDetails;

import java.util.List;

public interface AppService {
    List<LeaveDetails> findAll();
    public LeaveDetails findById(int id);
    LeaveDetails save(LeaveDetails leaveDetails);
    LeaveDetails update(LeaveDetails leaveDetails);
    String delete(int id);

    //Employee Service
    List<EmployeeDetails> employeeFindAll();
    public EmployeeDetails employeeSave(EmployeeDetails employeeDetails);
    EmployeeDetails employeeFindById(int id);

    List<Current_project> getCurrProjValues();



}
