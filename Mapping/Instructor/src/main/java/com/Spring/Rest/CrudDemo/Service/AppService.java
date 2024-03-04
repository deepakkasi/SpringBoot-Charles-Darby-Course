package com.Spring.Rest.CrudDemo.Service;

import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;

public interface AppService {
    public void save(Instructor instructor);
    public Instructor findById(int id);
    public Instructor_detail findByInstructorDetailId(int id);
}
