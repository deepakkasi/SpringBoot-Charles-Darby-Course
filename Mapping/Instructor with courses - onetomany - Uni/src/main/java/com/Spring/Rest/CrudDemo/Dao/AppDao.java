package com.Spring.Rest.CrudDemo.Dao;

import com.Spring.Rest.CrudDemo.entity.Course;
import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;

import java.util.List;

public interface AppDao
{

    public void save(Instructor instructor);
    public void addCourse(Course course);
    public Instructor findById(int id);
    public Instructor_detail findByInstructorDetailsid(int id);
    public List<Course> findCourseById(int id);

}
