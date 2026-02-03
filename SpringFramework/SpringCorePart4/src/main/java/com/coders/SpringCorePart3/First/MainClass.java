package com.coders.SpringCorePart3.First;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/coders/SpringCorePart3/Xml/AnnotationEx.xml");
		//syntax:content.getBean(beanid which is given in Component annotation or class name in lower case,.class file)
//		Person person1=context.getBean("person",Person.class);
		Person person2=context.getBean("uppi",Person.class);
		
//		System.out.println(person1);
		System.out.println(person2);

	}

}
