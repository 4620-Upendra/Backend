package Com.Coders.SpringDataJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Com.Coders.SpringDataJPA.entity.Student;
import Com.Coders.SpringDataJPA.repository.MyStudentRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("Com/Coders/SpringDataJPA/Config/config.xml");
    	
    	//creating object for MyStudentRepo Interface which extend JpaRepository
    	MyStudentRepo repo=context.getBean(MyStudentRepo.class);
    	
    	Student s=context.getBean(Student.class);
    	s.setAge(22);
    	s.setName("uppi");
    	s.setEmail("uppi@gmail.com");
    	
    	//predefine methods
//    	repo.save(s);  //it create table insert student object into table as row
    	
    	//if student with id 1 not found means gives error
//    	Optional<Student>op= repo.findById(1);
//    	System.out.println(op.get());
//        System.out.println( "Hello World!" );
    	
    	//user define methods
    	//i)findBy
//        Student st=	repo.findBySid(1);
//        System.out.println(st);
        
//        Student st1=repo.findByName("uppi");
//        System.out.println(st1);
    	
//    	 List<Student>list= repo.findByAgeGreaterThan(20);
//    	 for(Student st:list) {
//    		 System.out.println(st);
//    	 }
    	
    	//ii)countBy
//    	System.out.println(repo.countByAgeGreaterThan(20));
    	
    	//iii)deleteBy
    	//predefine method
//    	repo.deleteById(2);
    	
//    	repo.deleteByName("uppi");
    	
    	
    	//1*)jpql
//    	List<Student>list= repo.getAllStudents();
//   	    for(Student st:list) {
//   	    	System.out.println(st);
//   	    }
    	
//    	List<Student>list= repo.getAllStudentsById();
//	    for(Student st:list) {
//	    	System.out.println(st);
//	    }
    	
//    	List<Student>list= repo.getAllStudentsById(3);
//	    for(Student st:list) {
//	    	System.out.println(st);
//	    }
    	
    	// 2*)Native query lanuage(normal sql)
//    	List<Student>list= repo.printAllStudents();
//	    for(Student st:list) {
//	    	System.out.println(st);
//	    }
    	
//    	List<Student>list= repo.printAllStudentsById(2);
//	    for(Student st:list) {
//	    	System.out.println(st);
//	    }
    	
    	List<Student>list= repo.printAllStudentsByName("uppi");
	    for(Student st:list) {
	    	System.out.println(st);
	    }

    	
    	
      System.out.println( "Hello World!" );
    }
}
