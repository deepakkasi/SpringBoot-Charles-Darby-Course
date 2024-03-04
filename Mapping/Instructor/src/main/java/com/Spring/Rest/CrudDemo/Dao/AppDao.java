package com.Spring.Rest.CrudDemo.Dao;

import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;

public interface AppDao
{

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public Instructor_detail findByInstructorDetailsid(int id);

}
