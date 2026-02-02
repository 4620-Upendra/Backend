package com.coders.SpringCorePart2.First;

public class Location {
     private int pin;
     private String city;
     
	 public Location() {
		super();
	 }
	 public Location(int pin, String city) {
		super();
		this.pin = pin;
		this.city = city;
	 }
	 public int getPin() {
		 return pin;
	 }
	 public void setPin(int pin) {
		 this.pin = pin;
	 }
	 public String getCity() {
		 return city;
	 }
	 public void setCity(String city) {
		 this.city = city;
	 }
	 @Override
	 public String toString() {
		return "Location [pin=" + pin + ", city=" + city + "]";
	 }
     
     
}
