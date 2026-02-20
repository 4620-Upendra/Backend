package Com.Coders.SpringJDBC;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Com.Coders.SpringJDBC.Service.ServiceImp;
import Com.Coders.SpringJDBC.Service.Service;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Com/Coders/SpringJDBC/xmlconfig/config.xml");
//		System.out.println("hello");
		
	Service service =context.getBean(ServiceImp.class);
	Scanner sc=new Scanner(System.in);
	
	Boolean isrunning=true;
	while(isrunning) {
		
		System.out.print("Enter operation (insert / update / delete / selectById /ViewAll): ");
		String op=sc.nextLine();
		
		if((op.toLowerCase()).equals("insert")) {
			
		service.insertDataIntoStudent();	
		
		}else if((op.toLowerCase()).equals("update")) {
			
			service.updateStudentData();		
			
		}else if((op.toLowerCase()).equals("delete")) {
			
			service.delete();
			
		}else if(op.equalsIgnoreCase("selectbyid")) {
			service.selectById();
			
		}else if(op.equalsIgnoreCase("viewall")) {
			service.viewAll();
		}else {
			 System.out.println("Invalid operation. Try again.");
		}
		
//		System.out.println("operation completed");
	
		System.out.print("Do you want to continue? (Y/N): ");
		String run=sc.nextLine();
		
		System.out.println();
		if(run.equalsIgnoreCase("n")) {
			isrunning=false;
		}
		
		}
//	sc.close();
	}
	

}
