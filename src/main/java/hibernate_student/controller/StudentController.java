package hibernate_student.controller;

import java.util.Scanner;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Student student = new Student();
		StudentDao dao = new StudentDao();

		System.out.println(
				"Enter the choice\n1.Save Student\n2.Find all Student\n3.Update Student\n4.Delete Student\n5.Find Student by id\n6.Find Student by Phone \n7.Find Student by Email");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			//save student
			System.out.println("Enter the student id:");
			int id = scanner.nextInt();
			System.out.println("Enter the student name:");
			String name = scanner.next();
			System.out.println("Enter the marks:");
			int marks = scanner.nextInt();
			System.out.println("Enter the phone number");
			long phone = scanner.nextLong();
			System.out.println("Enter the student address:");
			String address = scanner.next();
			System.out.println("Enter the student email:");
			String email = scanner.next();

			student.setId(id);
			student.setName(name);
			student.setAddress(address);
			student.setEmail(email);
			student.setMarks(marks);
			student.setPhone(phone);

			dao.saveStudent(student);
			System.out.println("Student data save successfully");

			break;

		}
		case 2:{
			//find all student
			dao.getAllStudent();
			System.out.println("Get all student successfully");
			break;	
		}
		case 3: {
			//update student
			System.out.println("Enter the student id:");
			int id = scanner.nextInt();
			System.out.println("Enter the student name:");
			String name = scanner.next();
			System.out.println("Enter the marks:");
			int marks = scanner.nextInt();
			System.out.println("Enter the phone number");
			long phone = scanner.nextLong();
			System.out.println("Enter the student address:");
			String address = scanner.next();
			System.out.println("Enter the student email:");
			String email = scanner.next();
			
			student.setId(id);
			student.setName(name);
			student.setAddress(address);
			student.setEmail(email);
			student.setMarks(marks);
			student.setPhone(phone);

		
		    dao.updateStudent(student);
		    System.out.println("student data updated successfully");
			break;
		}
		case 4: {
			//delete student
			System.out.println("Enter the student id:");
			int id = scanner.nextInt();
			student.setId(id);

		
			dao.deleteStudent(id);
			System.out.println("Data Deleted Successfully");
			break;
		}
		case 5: {
			//find student by id
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			
			dao.getStudent();
		
			break;
		}
		case 6: {
			//find student by phone no
			System.out.println("Enter the phone number");
			long phone = scanner.nextLong();
			
			dao.getStudent(phone);
			


			break;
		}
		case 7: {
			//find student by email
			System.out.println("Enter the email:");
			String email=scanner.next();
			
			dao.getStudent(email);
			break;
		}

		default:
		
			break;
		}

	}

}
