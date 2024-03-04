package com.Spring.Rest.CrudDemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="id")
    int id;

    @Column(name="first_name")
    String first_name;
    @Column(name="last_name")
    String last_name;
    @Column(name="email")
    String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    Instructor_detail instructor_detail;
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "instructor",cascade = {CascadeType.MERGE, CascadeType.PERSIST
            , CascadeType.DETACH, CascadeType.REFRESH})
    public List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Instructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instructor_detail getInstructor_detail() {
        return instructor_detail;
    }

    public void setInstructor_detail(Instructor_detail instructor_detail) {
        this.instructor_detail = instructor_detail;
    }

    public Instructor(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "instructor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", instructor_detail='" + instructor_detail + '\'' +
                '}';
    }
    public void add(Course Tempcourse){
        if(course==null){
            course=new ArrayList<>();
        }
        course.add(Tempcourse);
        Tempcourse.setInstructor(this);
    }

}



