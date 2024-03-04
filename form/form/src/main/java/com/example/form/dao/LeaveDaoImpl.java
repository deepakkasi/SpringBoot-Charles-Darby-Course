package com.example.form.dao;

import com.example.form.entity.LeaveDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaveDaoImpl implements LeaveDao{


    public EntityManager entityManager;
    @Autowired
    public LeaveDaoImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    public List<LeaveDetails> findAll() {
        TypedQuery theQuery=entityManager.createQuery("FROM LeaveDetails", LeaveDetails.class);
        List<LeaveDetails> result=theQuery.getResultList();
        System.out.println(result);
        return result;

    }
    @Override
    public LeaveDetails findById(int id) {
        LeaveDetails result=entityManager.find(LeaveDetails.class,id);
        System.out.println(result);
        return  result;

    }

    @Override
    @Transactional
    public LeaveDetails save(LeaveDetails leaveDetails) {
        System.out.println(leaveDetails.getFrom_date());

        entityManager.persist(leaveDetails);
        LeaveDetails result=findById(leaveDetails.getId());
        return result;

    }

    @Override
    @Transactional
    public LeaveDetails update(LeaveDetails leaveDetails) {
        LeaveDetails result=entityManager.merge(leaveDetails);
        return result;
    }

    @Override
    @Transactional
    public int delete(int id) {
        entityManager.remove(findById(id));
        return id;
    }



}
