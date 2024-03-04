package com.Spring.Rest.CrudDemo;

import com.Spring.Rest.CrudDemo.Dao.AppDao;
import com.Spring.Rest.CrudDemo.entity.Course;
import com.Spring.Rest.CrudDemo.entity.Instructor;
import com.Spring.Rest.CrudDemo.entity.Instructor_detail;
import com.Spring.Rest.CrudDemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//createCourseConstructor(appDao);
			//createConstructor(appDao);
			//createCourseAndReviews(appDao);
			createReviewConstructor(appDao);
		};
	}

	private void createReviewConstructor(AppDao appDao) {
		System.out.println("Save Start");

		Instructor_detail instructorDetail=new Instructor_detail("www.ssyoutube@google.com"
				,"cricket");
		Instructor instructor=new Instructor(
				"ray","woo","ray@google.com"
		);
		instructor.setInstructor_detail(instructorDetail);
		Course tempCourse1=new Course("Harry potter5");
		Course tempCourse2=new Course("Harry potter6");
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		System.out.println("Save Start");
		System.out.println(instructor);
		System.out.println("Instructor Detail from instructor");
		System.out.println(instructor.getInstructor_detail());
		System.out.println("Instructor  from instructorDetail");
		System.out.println(instructorDetail.getInstructor());
		appDao.save(instructor);
		System.out.println("Save End");
		System.out.println("Course from instructor");

	}

	private void createConstructor(AppDao appDao) {

		System.out.println("Read Start");

		Instructor instructor=appDao.findById(1);

		System.out.println(instructor);
		System.out.println("Instructor Details");
		System.out.println(instructor.getInstructor_detail());


		System.out.println("Instructor Course");
		List<Course> course=appDao.findCourseById(1);
		instructor.setCourse(course);
		System.out.println(instructor.getCourse());
		System.out.println("Read End");


	}
	private void createCourseConstructor(AppDao appDao) {

		System.out.println("Save Start");

		Instructor_detail instructorDetail=new Instructor_detail("www.youtube@google.com"
				,"football");
		Instructor instructor=new Instructor(
				"Ken","Kaneki","ken@google.com"
		);
		instructor.setInstructor_detail(instructorDetail);
		Course tempCourse1=new Course("Harry potter1");
		Course tempCourse2=new Course("Harry potter2");
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		System.out.println("Save Start");
		System.out.println(instructor);
		System.out.println("Instructor Detail from instructor");
		System.out.println(instructor.getInstructor_detail());
		System.out.println("Instructor  from instructorDetail");
		System.out.println(instructorDetail.getInstructor());
		appDao.save(instructor);
		System.out.println("Save End");
		System.out.println("Course from instructor");
		System.out.println(instructor.getCourse());


		System.out.println("Read End");


	}

	private void createCourseAndReviews(AppDao appDAO) {

		// create a course
		Course tempCourse = new Course("Ironman - How To Score One Million Points");

		// add some reviews
		tempCourse.add(new Review("Great course ... loved it!"));
		tempCourse.add(new Review("Cool course, job well done."));
		tempCourse.add(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReview());

		appDAO.addCourse(tempCourse);

		System.out.println("Done!");
	}

}
