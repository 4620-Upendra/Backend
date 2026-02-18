package SpringCorePartIV.First;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("SpringCorePartIV/XmlConfig/Config.xml");
		
		Person person=(Person) context.getBean("uppi");
		System.out.println(person);

	}

}
