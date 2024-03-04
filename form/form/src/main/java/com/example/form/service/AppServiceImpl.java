package com.example.form.service;

import com.example.form.Lov.Current_project;
import com.example.form.dao.CurrentProjectDao;
import com.example.form.dao.EmployeeDao;
import com.example.form.dao.LeaveDao;
import com.example.form.entity.EmployeeDetails;
import com.example.form.entity.LeaveDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppServiceImpl implements AppService {

    public LeaveDao leaveDao;
    public EmployeeDao employeeDao;
    public CurrentProjectDao currentProjectDao;
    @Autowired
    public AppServiceImpl(LeaveDao leaveDao,EmployeeDao employeeDao,CurrentProjectDao currentProjectDao){

        this.leaveDao=leaveDao;
        this.employeeDao=employeeDao;
        this.currentProjectDao=currentProjectDao;
    }




    @Override
    public List<LeaveDetails> findAll() {
        return leaveDao.findAll();

    }

    @Override
    public LeaveDetails findById(int id) {
        return leaveDao.findById(id);
    }

    @Override
    public LeaveDetails save(LeaveDetails leaveDetails)
    {
        leaveDetails.setId(0);
        return leaveDao.save(leaveDetails);
    }

    @Override
    public LeaveDetails update(LeaveDetails leaveDetails) {
        return leaveDao.update(leaveDetails);
    }

    @Override
    public String delete(int id) {
        int result=leaveDao.delete(id);
        return "Id : "+result+" has been removed from the system";
    }

    @Override
    public List<EmployeeDetails> employeeFindAll() {
        return employeeDao.findAll();
    }
    @Override
    public EmployeeDetails employeeSave(EmployeeDetails employeeDetails) {
        return employeeDao.employeeSave(employeeDetails);
    }

    @Override
    public EmployeeDetails employeeFindById(int id) {
        return employeeDao.employeeFindById(id);
    }

    @Override
    public List<Current_project> getCurrProjValues() {

        return currentProjectDao.findAll();
    }


}
