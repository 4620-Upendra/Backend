package com.coders.SpringCore.First;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		Student st1=new Student();  //pojo(plane old java object)
		
		//bean (object created by spring framwork )
        ApplicationContext context	=new ClassPathXmlApplicationContext("com/coders/SpringCore/Xml/myconfig.xml");
        
        //four ways to create object using getBean method
        
        //i)context.getBean(id):returns object needs to downcosting to student object and create n number of objects
//        Student student=(Student)context.getBean("std");       //works only when there is no parameter constructor 
        
        //ii)context.getBean(.class file):creates single object and reassign values and no need downcosting
//        Student studen1t=(Student)context.getBean(Student.class);
        
        //iii)context.getBean(id,.class file):create n number of objects and no need to downcoasting to student class
//        Student student2=context.getBean("std",Student.class);
//        student2.setSid(20);
//        student2.setName("Uppi");
//        student2.setLocation("vizag");
//        student2.setAge(23);
//        System.out.println(student2);
//        System.out.println("Bean created");
        
        //iv)context.getBean(id,argument1,argument2.argument3......arguments)
        //works only when there scope of Bean is prototype
//        Student student3=(Student)context.getBean("std",20,"uppi",23,"vizag");
//		System.out.println(student3);
//		
		
		
        
        
		//topic: scope of Bean
        //i)singleton:creates only one object that before calling getBean method because object is created when project is runned then first xml configuration is executed first then main class
        //singleton scope is worked only when there is no parameter constructor in Student class
//        Student st=(Student)context.getBean("std");
//        System.out.println(st);
//        Student st1=(Student)context.getBean("std");  // in singleton scope only one object is created and if try to create more than one object means use same object which is created first
//        System.out.println(st1);
//        Student st2=(Student)context.getBean("std");
//        System.out.println(st2);
        
        //ii)prototype:creates object only when getBean method is called and we can create multiple object when each time getBean method is called
//      Student st=(Student)context.getBean("std");
//      System.out.println(st);
//      Student st1=(Student)context.getBean("std"); 
//      System.out.println(st1);
//      Student st2=(Student)context.getBean("std",20,"uppi",22,"vizag");
//      System.out.println(st2);
        

        //constructor injection
        Student st=(Student)context.getBean("std");
       System.out.println(st);
        
        
	}

}
