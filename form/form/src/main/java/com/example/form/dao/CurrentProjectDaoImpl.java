package com.example.form.dao;

import com.example.form.Lov.Current_project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrentProjectDaoImpl implements CurrentProjectDao{
    private EntityManager entityManager;
    @Autowired
    public CurrentProjectDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Current_project> findAll() {
        TypedQuery<Current_project> theQuery=entityManager.createQuery("FROM Current_project",Current_project.class);
        List<Current_project> result=theQuery.getResultList();
        return result;
    }
}
