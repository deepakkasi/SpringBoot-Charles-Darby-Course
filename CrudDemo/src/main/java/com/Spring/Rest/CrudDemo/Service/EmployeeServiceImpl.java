package com.Spring.Rest.CrudDemo.Service;

import com.Spring.Rest.CrudDemo.EmployeeDao.EmployeeDao;
import com.Spring.Rest.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
       return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public Employee updateById(Employee employee) {

        return employeeDao.updateById(employee);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return employeeDao.deleteById(id);
    }
}
