package com.example.form;

import com.example.form.dao.LeaveDao;
import com.example.form.entity.LeaveDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FormApplication {

	public static void main(String[] args) {

		SpringApplication.run(FormApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner commandLineRunner(LeaveDao leaveDao){
		return runner->{
		//leaveDao.findAll();
			//createLeave(leaveDao);
			//updateLeave(leaveDao);
			//leaveDao.findById(4);
			//deleteLeave(leaveDao);
		};

	}

	private void createLeave(LeaveDao leaveDao) {
		Date start=new Date();
		LeaveDetails leave=new LeaveDetails(
				1003,"mahora","Approved",start,start,"2","personal work","kai"
		);
		leaveDao.save(leave);
		leaveDao.findAll();
	}
	private void updateLeave(LeaveDao leaveDao) {
		Date start=new Date();
		LeaveDetails leave=leaveDao.findById(4);
		leave.setEmployee_name("Tobi");
		leaveDao.update(leave);
		leaveDao.findById(4);
	}
	private void deleteLeave(LeaveDao leaveDao) {


		System.out.println(leaveDao.delete(5));
		leaveDao.findAll();

	}
*/
}
