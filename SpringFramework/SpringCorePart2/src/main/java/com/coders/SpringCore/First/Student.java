package com.coders.SpringCore.First;

public class Student {
	private int sid;
	private String name;
	private int age;
	private String location;
//	public Student() {
//		System.out.println("i am singleton");
//	}
	public Student() {
		System.out.println("i am prototype");
	}
	public Student(int sid, String name, int age, String location) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.location = location;
	}
	public int getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getLocation() {
		return location;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", location=" + location + "]";
	}
	

}
