package com.Spring.Rest.CrudDemo.Service;

import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AppserviceImpl implements AppService
{

    private EntityManager entityManager;
    @Autowired
    public AppserviceImpl(EntityManager entityManager){
        this.entityManager=entityManager;

    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
       entityManager.persist(instructor);
        System.out.println(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor result=entityManager.find(Instructor.class,id);
        return result;
    }

    @Override
    public Instructor_detail findByInstructorDetailId(int id) {
        Instructor_detail result=entityManager.find(Instructor_detail.class,id);

        return result;
    }
}
