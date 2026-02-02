package com.coders.SpringCorePart2.First;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/coders/SpringCorePart2/Xml/exconfig.xml");
		Student st1=(Student)context.getBean("std");
		System.out.println("Bean created by using "+st1.getName());
		System.out.println(st1);
	}

}
