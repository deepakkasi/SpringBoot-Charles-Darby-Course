package com.Spring.Rest.CrudDemo.Dao;

import com.Spring.Rest.CrudDemo.Service.AppService;
import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class AppDaoImpl implements AppDao {

    private AppService appService;

    @Autowired
    public AppDaoImpl(AppService appService) {
        this.appService = appService;



    }


    @Override
    public void save(Instructor instructor) {
        appService.save(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return appService.findById(id);
    }

    @Override
    public Instructor_detail findByInstructorDetailsid(int id) {
        return appService.findByInstructorDetailId(id);
    }
}
