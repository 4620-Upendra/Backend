package SpringCorePartIV.First;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Address1")
public class Address1 implements Location {

	@Value("20")
	private int id;
	@Value("vizag")
	private String city;
	public Address1() {
		super();
	}
	public Address1(int id, String city) {
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
		return "Address1 [id=" + id + ", city=" + city + "]";
	}

}
