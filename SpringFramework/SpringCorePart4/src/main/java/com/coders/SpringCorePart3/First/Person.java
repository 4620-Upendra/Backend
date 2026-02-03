package com.coders.SpringCorePart3.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Annotations tell the Spring container what to do.

@Component("uppi")  //or @Component :it creates bean for this class
//@Component

@Scope("prototype")  //tells how many beans we can create
//@Scope(singleton)  this is by default and we can create only one bean and its created before we call it by getBean method

public class Person {
	
	@Value("101")    //Injecting Values  and this is field injection(1)
	private int id;
	
	@Value("uppi")  // field injection
	private String name;
	
	@Value("22")
	private int age;
	
	@Autowired     //field injection
	//Autowired:Injects one bean into another automaticlly based on type
	private Location location;
//	public Person() {
//		super();
//	}
	
	//2)Constructor injection in Value Annotation
	public Person(@Value("102") int id,@Value("Amosh") String name,@Value("21") int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		
	}
	

	public int getId() {
		return id;
	}
   //3)setter injection   (in value annotation)
	//@Value("103")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	//@Value("ashu")   //setter injection
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	//@Value("20")   //setter injection
	public void setAge(int age) {
		this.age = age;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + "]";
	}
	
	
	

	
}
