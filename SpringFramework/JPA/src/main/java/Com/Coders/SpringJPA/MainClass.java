package Com.Coders.SpringJPA;

import java.util.List;

import Com.Coders.SpringJPA.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainClass {

	

	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("SpringJPA");   //(argument is project name) 
		EntityManager manager=factory.createEntityManager();
	    EntityTransaction transaction= manager.getTransaction();
	    
	    transaction.begin();      // transaction begines here
	    Student st=new Student(2,"amosh",21,"vizag");
	    //1)persist(object reference):insert row into table
//	    manager.persist(st);       //st data is insert into student table as row
	    
	    //2)find(class file,primary id of row) returns class file object and slects only single row
	   Student st1= manager.find(Student.class, 2);
	   
	   //3)merge(object reference):update row in table
//	   if(st1!=null) {
//		   st1.setLocation("hyb");
//		   manager.merge(st1);
//	   System.out.println("row updated");
//	   }
//	   Student st2= manager.find(Student.class, 2);
	   
	  //4)remove(object reference):delete the row 
//	   if(st1!=null) {
//		   manager.remove(st1);
//		   System.out.println("row deleted");
//	   }
//	   Student st2= manager.find(Student.class, 2);
//	   System.out.println(st2);
	    
	   
	    //5) createQuery():to get all rows from table we have to create our own table
	   //createQuery(table name(class name),class file ).getResultList()=returns rows in list from
	   List<Student>list=manager.createQuery("from Student",Student.class).getResultList();
	   
	   for(Student stud:list) {
		   System.out.println(stud);
	   }
	    
	    transaction.commit();      //transaction is saved
	    manager.close();
	    factory.close();

	}

}
