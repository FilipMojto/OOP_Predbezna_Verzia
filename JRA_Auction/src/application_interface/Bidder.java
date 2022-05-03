package application_interface;

import java.io.Serializable;

public class Bidder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private char privilige;
	
	public String getName() {
		return this.name;
	}
	
	public Character getPrivilige() {
		return this.privilige;
	}
	
	public Bidder(String name, char privilige) {
		this.name = name;
		this.privilige = privilige;
	}
}
