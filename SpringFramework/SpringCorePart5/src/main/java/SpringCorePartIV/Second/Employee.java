package SpringCorePartIV.Second;

import org.springframework.beans.factory.annotation.Value;



public class Employee {

//	@Value("1001")
	private int id;
//	@Value("uppi")
	private String name;
	@Value("7000000")
	private double salary;
//	@Value("vizag")
	private String loc;
	public Employee() {
		super();
	}
	public Employee(int id, String name, double salary, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", loc=" + loc + "]";
	}
	
	

}
