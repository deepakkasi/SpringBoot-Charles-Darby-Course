package com.crud.Dao;

import com.crud.entity.Student;

import java.util.List;

public interface StudentDao
{
    public void save(Student student);
    public Student findById(int id);

    public List<Student> findAll() ;
    public List<Student> findByLastName(String last_name);

    public void update(Student student);
    public int deleteById(int id);
    public int deleteAll();

}
