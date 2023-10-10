package com.springcore.orm.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.orm.springorm.dao.StudentDao;
import com.springcore.orm.springorm.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static Scanner scanner = new Scanner(System.in);
	public static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	public static StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

	public static void main(String[] args) {
		printActions();
		
		executeOperation();
		
		
	}

	public static void executeOperation() {
		
		
		boolean flag=true;
		while(flag) {
			int choice=scanner.nextInt();
			switch (choice) {
			
			case 0:
				flag = false;
				break;
			case 1:
				
				addStudentrecord();
				printActions();
				
				break;
			case 2:
				showAllStudentsRecord();
				printActions();			
				break;
			case 3:
				showSingleStudent();
				printActions();
				break;
			case 4:
				deleteStudentRecord();
				printActions();
				break;
			case 5:
				updateStudentRecord();
				printActions();
				break;
			default:
				flag = false;
				break;

			}
		}

	}

	private static void deleteStudentRecord() {
		// TODO Auto-generated method stub
		System.out.println("Enter student id to delete");
		int id=scanner.nextInt();
		studentDao.deleteStudent(id);
		
	}

	private static void showSingleStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		System.out.println();;
		int id=scanner.nextInt();
		Student student=studentDao.getStudent(id);
		System.out.println(student);
	}

	private static void showAllStudentsRecord() {
		// TODO Auto-generated method stub
		
		List<Student> allStudent = studentDao.getAllStudent();
		for (Student student : allStudent) {
			System.out.println(student);
		}
	}

	private static void addStudentrecord() {
		
				System.out.println("Enter Student id");
				int id=scanner.nextInt();
				 scanner.nextLine();
				System.out.println("Enter Name of the Student");
				String name=scanner.nextLine();
				
				System.out.println("Enter New City of the Student");
				
				String city=scanner.nextLine();
				
				studentDao.insert(new Student(id,name,city));
	}

	private static void updateStudentRecord() {
		// TODO Auto-generated method stub
		System.out.println("Enter id which you want to update");
		int id=scanner.nextInt();
		 scanner.nextLine();
		System.out.println("Enter New Name of Student");
		String name=scanner.nextLine();
		
		System.out.println("Enter New City of Student");
		
		String city=scanner.nextLine();
		
		studentDao.updateStudent(new Student(id,name,city));
	}



	private static void printActions() {

		String textBlock = """
				Available actions:

				0 - To Exit
				1 - To Add new Student
				2 - To Show All Students
				3- To Show Single Student
				4- To To Delete Student
				5- To Update Student

				Enter a number for which action you want to do:""";
		System.out.print(textBlock + " ");
	}
}
