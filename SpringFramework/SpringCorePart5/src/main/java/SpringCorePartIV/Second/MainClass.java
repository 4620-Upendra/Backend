package SpringCorePartIV.Second;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import SpringCorePartIV.First.Person;

public class MainClass {

    public static void main(String[] args) {

        ApplicationContext context =                        //Configuration class name
                new AnnotationConfigApplicationContext(EmployeeConfig.class);

        String s = context.getBean("getStr", String.class);
//        System.out.println(s);
                                      //getEmp method in employeeconfig act as bean id
        Employee emp1=context.getBean("getEmp",Employee.class);
//        System.out.println(emp1);
        
        Employee emp2=context.getBean("getEmp1",Employee.class);
        System.out.println(emp2);
        
        Person per1=context.getBean("getPerson",Person.class);
        System.out.println(per1);
    }
}
