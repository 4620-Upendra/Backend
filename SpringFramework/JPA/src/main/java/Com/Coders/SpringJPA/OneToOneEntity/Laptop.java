package Com.Coders.SpringJPA.OneToOneEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Increment(Automatically generates the primary key value.)
    private int id;

    private String brand;

    public Laptop() {
    }

    public Laptop(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop [id=" + id + ", brand=" + brand + "]";
    }
}