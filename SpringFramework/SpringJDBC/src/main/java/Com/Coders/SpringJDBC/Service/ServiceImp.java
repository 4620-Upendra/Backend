package Com.Coders.SpringJDBC.Service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Com.Coders.SpringJDBC.DaoLayer.Dao;
import Com.Coders.SpringJDBC.entity.Student;

@Component
public class ServiceImp implements Service {

	@Autowired
	Student std;
	
	@Autowired
	Dao dao;
	
	private Scanner sc=new Scanner(System.in);
	@Override
	public void insertDataIntoStudent() {
		
		
		System.out.println("enter student details for insert");
		
		//taking input
		System.out.println("enter id:");
		int id=sc.nextInt();
		System.out.println("enter name:");
		String name=sc.next();
		System.out.println("enter age:");
		int age=sc.nextInt();
		System.out.println("enter marks:");
		int marks=sc.nextInt();
//		sc.close();
		
		//assinging values to student object
		
		std.setId(id);
		std.setName(name);
		std.setAge(age);
		std.setMarks(marks);
		
		dao.insertData(std);
	}

	@Override
	public void updateStudentData() {
		
		
		System.out.println("enter student details to Update");
		
		//taking input
		System.out.println("enter id:");
		int id=sc.nextInt();
		std.setId(id);
		
		System.out.println("enter whate to update name,age,marks");
		String op=sc.next();
		if((op.toLowerCase()).equals("name")) {
			System.out.println("enter new name :");
			String name=sc.next();
			std.setName(name);
		}
		else if((op.toLowerCase()).equals("age")){
			System.out.println("enter new age:");
			int age=sc.nextInt();
			std.setAge(age);
		}
		else if((op.toLowerCase()).equals("marks")){
			System.out.println("enter new marks:");
			int marks=sc.nextInt();
			std.setMarks(marks);
		}
		else {
			System.out.println("inValid filed Try Again Later");
			return;
		}
		dao.updateData(std);
		
	}

	@Override
	public void delete() {
		System.out.println("enter student id to Delete");
		int id=sc.nextInt();
		std.setId(id);
		
		dao.deleteStd(std);
		
	}

	@Override
	public void selectById() {
		System.out.println("enter Student id:");
		std.setId(sc.nextInt());
		
		dao.selectStd(std);
	}

	@Override
	public void viewAll() {
		
		dao.viewAllStds();
		
	}
		
}
