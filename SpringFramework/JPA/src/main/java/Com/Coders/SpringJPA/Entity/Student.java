package Com.Coders.SpringJPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                //here it create table for student class
@Table(name="student")   //here table name is given as student if not given means takes class name as table name
public class Student {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String location;
	public Student() {
		super();
	}
	public Student(int id, String name, int age, String location) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + "]";
	}
//	
	
	
}
