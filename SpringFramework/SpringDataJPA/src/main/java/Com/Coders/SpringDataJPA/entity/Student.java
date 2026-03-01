package Com.Coders.SpringDataJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;

@Entity   //creates table
@Table(name="student")   //set table name student
@Component     //creates bean(object)
public class Student {
	
	@Id      //make as primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private Integer age;
	private String email;
	public Student() {
		super();
	}
	public Student(Integer sid, String name, Integer age, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
}
