package com.crud;

import com.crud.Dao.StudentDao;
import com.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//System.out.println("Saving Started");
			//CreateStudent(studentDao);
			CreateMultipleStudent(studentDao);
			//readStudent(studentDao);
			//readAllStudent(studentDao);
			//readByLastname(studentDao);
			//updateStudentById(studentDao);
			//deleteById(studentDao);
			//deleteAll(studentDao);

		};
	}

	private void readByLastname(StudentDao studentDao) {
		System.out.println("Retrive Started");
	List <Student>Result=studentDao.findByLastName("clause");
		for (Student student:Result
			 ) {
			System.out.println(student);

		}
		System.out.println("Retrive ended");
	}

	private void readAllStudent(StudentDao studentDao) {
		System.out.println("Read All Started");
		List<Student> result=studentDao.findAll();
		for(Student studentrow:result){
			System.out.println(studentrow);
		}
	}

	private void CreateStudent(StudentDao theStudentDao) {
		System.out.println("Saving Started");
		Student theStudent=new Student("riya","parker","parker143@gmail.com");
		theStudentDao.save(theStudent);
		System.out.println("Student Generated id : "+theStudent.getId());
	}
	private void CreateMultipleStudent(StudentDao theStudentDao) {
		Student theStudent=new Student("riya","parker","riyparker143@gmail.com");
		Student theStudent2=new Student("tom","clause","tom123@gmail.com");
		Student theStudent3=new Student("jin","sungwoo","jinwoo120@gmail.com");

		theStudentDao.save(theStudent);
		theStudentDao.save(theStudent2);
		theStudentDao.save(theStudent3);
		System.out.println("Student Generated id : "+theStudent.getId());
	}

	private void readStudent(StudentDao theStudentDao) {
		//Student theStudent=new Student("peter","parker","parker143@gmail.com");
		////Student theStudent=new Student("bill","parker","parker143@gmail.com");
		//theStudentDao.save(theStudent);
		System.out.println("Reading Started");
		theStudentDao.findById(5);
		System.out.println(theStudentDao.findById(2).toString());
		System.out.println("Student Retrived");

	}

	private void updateStudentById(StudentDao theStudentDao) {
		//Student theStudent=new Student("peter","parker","parker143@gmail.com");
		////Student theStudent=new Student("bill","parker","parker143@gmail.com");
		//theStudentDao.save(theStudent);
		System.out.println("Update Started");
		Student result=theStudentDao.findById(5);
		System.out.println(result.toString());
		result.setFirstName("Rithi");
		theStudentDao.update(result);
		System.out.println("After Update");
		System.out.println(result.toString());
		System.out.println("Student Retrived");

	}

	private void deleteById(StudentDao theStudentDao) {
		//Student theStudent=new Student("peter","parker","parker143@gmail.com");
		////Student theStudent=new Student("bill","parker","parker143@gmail.com");
		//theStudentDao.save(theStudent);
		System.out.println("Delete Started");
		Student result=theStudentDao.findById(5);
		System.out.println(result.toString());
		result.setFirstName("Rithi");
		theStudentDao.deleteById(result.getId());
		System.out.println("After Delete");
		//System.out.println(result.toString());
		System.out.println("Student Deleted");

	}
	private void deleteAll(StudentDao theStudentDao) {
		//Student theStudent=new Student("peter","parker","parker143@gmail.com");
		////Student theStudent=new Student("bill","parker","parker143@gmail.com");
		//theStudentDao.save(theStudent);
		System.out.println("Delete All  Started");


		System.out.println("After Delete All");
		//System.out.println(result.toString());
		theStudentDao.deleteAll();
		System.out.println("Student Deleted");

	}

}
