package application_interface.main_package;

import java.io.Serializable;
import java.util.LinkedList;
import other.PriviligeLevels.BidderPrivilige;

import other.PriviligeLevels;

public class Bidder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	BidderPrivilige privilige;
	private String name;
	private String password;
	
	public String getName() {
		return this.name;
	}
	
	public void setPrivilige(PriviligeLevels.BidderPrivilige privilige) {
		this.privilige = privilige;
	}
	
	public BidderPrivilige getPrivilige() {
		return this.privilige;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Bidder(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
