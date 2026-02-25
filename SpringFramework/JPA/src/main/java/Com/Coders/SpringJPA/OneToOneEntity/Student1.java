package Com.Coders.SpringJPA.OneToOneEntity;


import jakarta.persistence.*;

@Entity
@Table(name = "student1")
public class Student1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Increment
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)   //Defines a One-to-One relationship between two entities.
    //cascade:  Applies operations automatically(persist, merge, remove, etc.)
    @JoinColumn(name = "laptop_id")   // Foreign key column(Creates a foreign key column in this table.)
    private Laptop laptop;

    public Student1() {
    }

    public Student1(String name, Laptop laptop) {
        this.name = name;
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", laptop=" + laptop + "]";
    }
}