package com.rest.restApi.controller;

import com.rest.restApi.Dao.Student;
import com.rest.restApi.Dao.StudentErrorResponse;
import com.rest.restApi.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> Students;
    @PostConstruct
    public void loadData(){
        Students =new ArrayList<Student>();
        Student student1=new Student("ravi","kumar");
        Student student2=new Student("jin","woo");
        Students.add(student1);
        Students.add(student2);

    }
    @GetMapping("/student")
    public List<Student> getStudent(){
        return Students;
    }
    @GetMapping("/student/{studentid}")
    public Student getStudentById(@PathVariable int studentid){
        if(studentid>=Students.size() || studentid<0){
            throw new StudentNotFoundException("Student not found with id : "+studentid);
        }


        return Students.get(studentid);
    }

}
