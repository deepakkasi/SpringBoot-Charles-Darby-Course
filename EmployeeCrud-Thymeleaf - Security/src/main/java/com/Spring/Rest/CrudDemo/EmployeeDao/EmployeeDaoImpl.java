package com.Spring.Rest.CrudDemo.EmployeeDao;

import com.Spring.Rest.CrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery= entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee>result=theQuery.getResultList();
        return result;
    }

    @Override
    public Employee findById(int id) {
        Employee result=entityManager.find(Employee.class,id);
        return result;
    }

    @Override
    public Employee save(Employee employee) {
        Employee result= entityManager.merge(employee);
        return result;
    }

    @Override
    public Employee updateById(Employee employee) {
        Employee result=entityManager.merge(employee);
        return employee;
    }

    @Override
    public int deleteById(int id) {
        Employee result=findById(id);
        entityManager.remove(result);
        return id;
    }

}
