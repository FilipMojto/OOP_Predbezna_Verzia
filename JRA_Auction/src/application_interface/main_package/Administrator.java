package application_interface.main_package;

import java.io.Serializable;

public class Administrator implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static Administrator admin;
	
	private char privilige;
	private String userName;
	private String password; 
	
	public void checkAuction() {
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Administrator getInstance(String userName, String password) {
		
		if(admin == null) {
			return admin = new Administrator(userName, password);
		}
		
		return admin;
	}
	
	private Administrator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}
