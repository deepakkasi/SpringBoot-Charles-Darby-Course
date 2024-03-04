package com.Spring.Rest.CrudDemo.Service;

import com.Spring.Rest.CrudDemo.entity.Course;
import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;

import java.util.List;

public interface AppService {
    public void save(Instructor instructor);
    public Instructor findById(int id);
    public Instructor_detail findByInstructorDetailId(int id);
    public List<Course> findCourseById(int id);
}
