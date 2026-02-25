package Com.Coders.SpringJPA;
import Com.Coders.SpringJPA.OneToOneEntity.Laptop;
import Com.Coders.SpringJPA.OneToOneEntity.Student1;
import jakarta.persistence.*;

public class OneToOneMainClass {
	    public static void main(String[] args) {

	        EntityManagerFactory factory =
	                Persistence.createEntityManagerFactory("SpringJPA");

	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();

	        transaction.begin();

	        // Create Laptop object
	        Laptop laptop = new Laptop("Dell");

	        // Create Student object
	        Student1 student = new Student1("Ravi", laptop);

	        // Persist only student (laptop also saved because of cascade)
	        manager.persist(student);

	        transaction.commit();

	        System.out.println("Record inserted successfully!");

	        manager.close();
	        factory.close();
	    }
	}

