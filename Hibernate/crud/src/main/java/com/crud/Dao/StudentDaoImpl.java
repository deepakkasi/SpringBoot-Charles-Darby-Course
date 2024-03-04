package com.crud.Dao;

import com.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class StudentDaoImpl  implements StudentDao
{
    private EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
    this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {

    entityManager.persist(student);

    }

    @Override
    public Student findById(int id) {

       return  entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery <Student> Query=entityManager.createQuery("FROM Student ORDER BY LastName DESC",Student.class);
        List Result=Query.getResultList();
        return Result;
    }
    @Override
    public List<Student> findByLastName(String last_name) {
        TypedQuery <Student> Query=entityManager.createQuery("FROM Student WHERE LastName =:last_name",Student.class);
        Query.setParameter("last_name",last_name);
        List<Student> Result=Query.getResultList();
        return Result;
    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge((student));
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        Student thestudent=entityManager.find(Student.class,id);
        entityManager.remove(thestudent);

        return id;
    }

    @Override
    @Transactional
    public int deleteAll() {
        int result=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return result;
    }


}
