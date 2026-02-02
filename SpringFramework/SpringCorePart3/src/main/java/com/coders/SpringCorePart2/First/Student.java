package com.coders.SpringCorePart2.First;

public class Student {
      private int id;
      private String name;
      private int age;
      private Location loc;
      public Student() {
    	  super();
      }
      
      public Student(Location loc) {
  		super();
  		this.loc = loc;
  	  }
      
      public Student(int id, String name, int age) {
  		super();
  		this.id = id;
  		this.name = name;
  		this.age = age;
  	  }
      
	  public Student(int id, String name, int age, Location loc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.loc = loc;
	  }

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public String getName() {
		  return name;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }

	  public int getAge() {
		  return age;
	  }

	  public void setAge(int age) {
		  this.age = age;
	  }

	  public Location getLoc() {
		  return loc;
	  }

	  public void setLoc(Location loc) {
		  this.loc = loc;
	  }

	  @Override
	  public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", loc=" + loc + "]";
	  }
	  
	 
	  
      
      
}
