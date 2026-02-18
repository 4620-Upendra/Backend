package SpringCorePartIV.Second;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import SpringCorePartIV.First.Person;

@Configuration  //@Configuration is used to declare a Java class as a Spring configuration class.  and It replaces the old XML configuration
@ComponentScan("SpringCorePartIV")    //“Scan this package and automatically create beans for classes annotated with: @Component
public class EmployeeConfig {

	@Bean     //@Bean is used inside a @Configuration class to create and manage objects manually.  and  “Create this object and store it in the Spring container.”
	public String  getStr() {
		return new String ("uppi");
	}
	
	
	@Bean
	@Scope("prototype")
	public Employee getEmp1() {
		return new Employee(1,"amosh",500000,"hyd");
	}
	
	@Bean
	public Employee getEmp() {
		return new Employee();
	}
	
	@Bean
	public Person getPerson() {
		return new Person();
	}
	
}
