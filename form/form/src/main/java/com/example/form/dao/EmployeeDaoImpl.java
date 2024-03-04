package com.example.form.dao;

import com.example.form.entity.EmployeeDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<EmployeeDetails> findAll() {
       TypedQuery<EmployeeDetails>theQuery= entityManager.createQuery("FROM EmployeeDetails", EmployeeDetails.class);
    List<EmployeeDetails> result=theQuery.getResultList();
        System.out.println(result);
        return result;
    }

    @Override
    @Transactional
    public EmployeeDetails employeeSave(EmployeeDetails employeeDetails) {

        entityManager.merge(employeeDetails);

        return employeeFindById(employeeDetails.getEmployee_id());
    }
    @Override

    public EmployeeDetails employeeFindById(int id) {
        EmployeeDetails result=entityManager.find(EmployeeDetails.class,id);
        return result;
    }

}
