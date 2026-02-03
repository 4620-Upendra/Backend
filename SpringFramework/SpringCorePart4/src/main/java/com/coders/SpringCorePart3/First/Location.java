package com.coders.SpringCorePart3.First;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Location {

	@Value("56")    //field injection by Value annotation
	private int lib;
	@Value("kphb")
	private String name;
	
	public Location() {
		super();
	}
	

	public int getLib() {
		return lib;
	}

	public void setLib(int lib) {
		this.lib = lib;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location(int lib, String name) {
		super();
		this.lib = lib;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Location [lib=" + lib + ", name=" + name + "]";
	}
	
}
