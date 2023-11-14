package com.luvcode.cruddemo;

import com.luvcode.cruddemo.dao.StudentDAO;
import com.luvcode.cruddemo.entity.Student;
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

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
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

       int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:" +numRowsDeleted);


	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("Deleting student id"+ studentId);
		studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId=2;
		System.out.println("Getting student with id"+ studentId);
		Student myStudent=studentDAO.findById(studentId);

		// change first name to "scooby"
		System.out.println("Updating student...");
		myStudent.setFirstname("Abdul");

		//update the student
		studentDAO.update(myStudent);


		System.out.println("Updated Student"+myStudent);




	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Rahman");
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents= studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

	 //creating student object
		System.out.println("Creating new student object ...");
        Student tempStudent=new Student("Daffy","Cone","daffy@luvcode.com");

	  //saving the student
		System.out.println("Saving the Student");
	    studentDAO.save(tempStudent);

	  //saved student
	  int theId=tempStudent.getId();
	  System.out.println("Saved student: Generated Id"+ theId);

	  //retrieve the student
	  System.out.println();
	  Student myStudent=studentDAO.findById(theId);

	  //display student
	  System.out.println("Found the student: "+ myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Abdul","Rahman","abcluvcode.com");
		Student tempStudent2 = new Student("Hitler","Syco","hitlerluvcode.com");
		Student tempStudent3 = new Student("jane","mer","janeuvcode.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Abdul","Rahman","abcluvcode.com");
		//save the student object

        System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Saved student.generate id: " + tempStudent.getId());
	}

}
