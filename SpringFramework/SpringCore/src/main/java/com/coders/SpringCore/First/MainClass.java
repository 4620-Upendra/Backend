package com.coders.SpringCore.First;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		Student st1=new Student();  //pojo(plane old java object)
		
		//bean (object created by spring framwork )
        ApplicationContext context	=new ClassPathXmlApplicationContext("com/coders/SpringCore/Xml/myconfig.xml");
        Student student1=context.getBean("std",Student.class);
        student1.setSid(20);
        student1.setName("Uppi");
        student1.setLocation("vizag");
        student1.setAge(23);
        System.out.println(student1);
        System.out.println("Bean created");
	}

}
