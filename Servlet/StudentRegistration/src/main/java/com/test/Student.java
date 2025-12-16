package com.test;

public class Student {

	private String name;
	private String email;
	private int age;
	private String course;
	
	public Student(String name, String email, int age, String course) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
}
