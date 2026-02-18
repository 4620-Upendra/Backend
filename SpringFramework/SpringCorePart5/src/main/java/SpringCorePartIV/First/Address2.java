package SpringCorePartIV.First;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Address2")
public class Address2 implements Location {

	@Value("11")
	private int id;
	@Value("Hyd")
	private String city;
	public Address2() {
		super();
	}
	public Address2(int id, String city) {
		super();
		this.id = id;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address2 [id=" + id + ", city=" + city + "]";
	}

}
