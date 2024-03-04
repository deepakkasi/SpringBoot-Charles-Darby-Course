package com.Spring.Rest.CrudDemo;

import com.Spring.Rest.CrudDemo.Dao.AppDao;
import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {
	private AppDao appDao;
	public CrudDemoApplication(AppDao appDao){
		this.appDao=appDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		System.out.println("start");
		return runner ->{
			createConstructor(appDao);
		};
	}

	private void createConstructor(AppDao appDao) {
		/*Instructor instructor=new Instructor(
				"john","ketamin","john@google.com"
		);*/
		/*Instructor_detail instructorDetail=new Instructor_detail("www.youtube.com"
				,"football");
		Instructor instructor=new Instructor(
				"Johan","Libert","johan@google.com"
		);

		instructor.setInstructor_detail(instructorDetail);
		System.out.println("Save Start");
		System.out.println(instructor);
		appDao.save(instructor);
		System.out.println("Save End");
		System.out.println("Read Start");
		System.out.println(appDao.findById(2));
		System.out.println("Read End");*/
		System.out.println("Read Start");

		Instructor_detail instructorDetail=appDao.findByInstructorDetailsid(3);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
		System.out.println("Read End");


	}

}
