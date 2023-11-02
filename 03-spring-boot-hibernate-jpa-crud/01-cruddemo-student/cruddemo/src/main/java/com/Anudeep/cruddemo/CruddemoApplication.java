package com.Anudeep.cruddemo;

import com.Anudeep.cruddemo.dao.StudentDAO;
import com.Anudeep.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // --> This will be executed once all the spring beans are loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		// This will help us to develop a spring boot command line application
		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all rows");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Number of rows deleted are : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;

		System.out.println("Deleting student ID : " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id : primary key

		int studentId = 1;
		System.out.println("Getting student with ID : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Paul"

		System.out.println("Updating student...");
		myStudent.setFirstName("Paul");

		// update the student

		studentDAO.update(myStudent);

		// display the updated student

		System.out.println("Updated student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students

		List<Student> studentList = studentDAO.findByLastName("Uppu");

		// display list of students

		for(Student tempStudent : studentList)
			System.out.println(tempStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students

		List<Student> myStudentList= studentDAO.findAll();

		// display the list of students

		for(Student tempStudent : myStudentList)
			System.out.println(tempStudent);
	}

	private void readStudent(StudentDAO studentDAO) {

		// create Student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the object
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student generated ID : " + theId);

		// Retrieve the student based on the id : primary key
		System.out.println("Retrieving the student with ID : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// creating multiple students

		Student student1 = new Student("Kavya", "Uppu", "kavya@gmail.com");
		Student student2 = new Student("Anudeep", "Uppu", "anudeep@gmail.com");
		Student student3 = new Student("Harshita", "Uppu", "harshita@gmail.com");

		// save student objects
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
