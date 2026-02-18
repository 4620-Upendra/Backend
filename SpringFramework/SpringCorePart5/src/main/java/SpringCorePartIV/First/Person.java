package SpringCorePartIV.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("uppi")
@Scope("prototype")
public class Person {
 
	@Value("21")
	private int id;
	@Value("kumar")
	private String name;
	@Value("27")
	private int age;
	@Autowired
	@Qualifier("Address2")      //To tell Spring exactly which bean to inject, we use @Qualifier.
	private Location loc;
	public Person() {
		super();
	}
	
//	@Autowired
//	public Person(Location loc) {
//		super();
//		this.loc = loc;
//	}
//
//	public Person(int id, String name, int age, Location loc) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.loc = loc;
//	}
	@Autowired
	public Person(@Value("1001")int id,@Value("upendra") String name,@Value("22") int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		
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
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", loc=" + loc + "]";
	}
	
	
}
