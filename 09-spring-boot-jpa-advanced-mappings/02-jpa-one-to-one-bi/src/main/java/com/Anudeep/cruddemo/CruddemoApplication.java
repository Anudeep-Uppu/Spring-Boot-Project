package com.Anudeep.cruddemo;

import com.Anudeep.cruddemo.dao.AppDAO;
import com.Anudeep.cruddemo.entity.Instructor;
import com.Anudeep.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 4;

		System.out.println("Removing Instructor Detail : " + theId);

		appDAO.removeInstructorDetailById(theId);

		System.out.println("Done!!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail by object
		int theId = 3;

		// print the instructor detail
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor details : " + instructorDetail);

		// print the associated instructor
		System.out.println("Associated instructor : " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;

		System.out.println("Deleting instructor " + theId);
		appDAO.removeInstructorById(theId);
		System.out.println("Done!!!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor id : " + theId);

		Instructor theInstructor = appDAO.findInstructorById(theId);

		System.out.println("The instructor details : " + theInstructor);
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor theInstructor = new Instructor("Uppu", "Anudeep", "abc@gmail.com");

		InstructorDetail theInstructorDetail = new InstructorDetail("www.abc.com", "Teaching");


		Instructor theInstructor1 = new Instructor("Uppu", "Kavya", "def@gmail.com");

		InstructorDetail theInstructorDetail1 = new InstructorDetail("www.def.com", "Working");


		// associate the objects for one-one mapping

		theInstructor.setInstructorDetail(theInstructorDetail);
		theInstructor1.setInstructorDetail(theInstructorDetail1);


		// save the instructor
		// NOTE : This will also save the instructor detail because it is cascade save
		System.out.println("Saving instructor : " + theInstructor);

		appDAO.save(theInstructor);
		appDAO.save(theInstructor1);

		System.out.println("Done!!!");
	}

}
