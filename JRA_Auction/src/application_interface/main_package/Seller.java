package application_interface.main_package;

import java.io.Serializable;

public class Seller implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private char privilige;
	private String name;
	private String password;
	
	public char getPrivilige() {
		return privilige;
	}

	public void setPrivilige(char privilige) {
		this.privilige = privilige;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Seller(String name, String password) {
		this.privilige = 'S';
		this.name = name;
		this.password = password;
	}
}
