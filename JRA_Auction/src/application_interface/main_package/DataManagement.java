package application_interface.main_package;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import application_interface.file_management.ObjectInput;
import application_interface.file_management.ObjectOutput;
import other.PriviligeLevels.BidderPrivilige;

public class DataManagement {
	private ObjectOutput objOut;
	private ObjectInput objIn;
	
	private Administrator admin;
	private HashMap<String, String> personDatabase;
	
	private LinkedList<Seller> sellerDatabase;
	private LinkedList<VIP_Bidder> VIP_BidderDatabase;
	private LinkedList<Bidder> bidderDatabase;
	
	public Administrator getAdmin() {
		return admin;
	}
	
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	public LinkedList<VIP_Bidder> getVIP_BidderDatabase(){
		return this.VIP_BidderDatabase;
	}
	
	public LinkedList<Bidder> getBidderDatabase(){
		return this.bidderDatabase;
	}
	
	public HashMap<String, String> getPersonDatabase() {
		return this.personDatabase;
	}

	public void updatePerson(Object object) throws IOException {
	
		this.objOut = new ObjectOutput(new File("src/files/serialized/personal_data.ser"));
		
		if(this.admin != null) {
			this.objOut.writeStream(admin);
		}
		
		for(int i = 0; i < this.sellerDatabase.size(); i++) {
			this.objOut.writeStream(sellerDatabase.get(i));
		}
		
		for(int i = 0; i < this.VIP_BidderDatabase.size(); i++) {
			this.objOut.writeStream(VIP_BidderDatabase.get(i));
		}
		
		for(int i = 0; i< this.bidderDatabase.size(); i++) {
			this.objOut.writeStream(bidderDatabase.get(i));
		}
				
		this.objOut.writeStream(object);
	}
	
	
	public void getPersonalData() {
		
		try {
			this.objIn = new ObjectInput(new File("src/files/serialized/personal_data.ser"));
		
			while(true) {
				Object obj = objIn.deserializeObject();
				
				if(obj instanceof Administrator) {
					this.admin = (Administrator)obj;
					this.personDatabase.put(this.admin.getUserName(), this.admin.getPassword());
				}
				else if(obj instanceof Seller) {
					Seller seller = (Seller)obj;
					
					this.personDatabase.put(seller.getName(), seller.getPassword());
					this.sellerDatabase.addLast(seller);
				}
				else if(obj instanceof VIP_Bidder) {
					VIP_Bidder VIP_Bidder = (VIP_Bidder)obj;
					VIP_Bidder.setPrivilige(BidderPrivilige.VIP_BIDDER);
					
					this.personDatabase.put(VIP_Bidder.getName(), VIP_Bidder.getPassword());
					this.VIP_BidderDatabase.addLast(VIP_Bidder);
				}
				else if(obj instanceof Bidder) {
					Bidder bidder = (Bidder)obj;
					bidder.setPrivilige(BidderPrivilige.BIDDER);
					
					this.personDatabase.put(bidder.getName(), bidder.getPassword());
					this.bidderDatabase.addLast(bidder);
				}
			}
		}
		catch(EOFException e) {}
		catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} 
	}

	public DataManagement() {
		this.personDatabase = new HashMap<>();
		this.VIP_BidderDatabase = new LinkedList<>();
		this.sellerDatabase = new LinkedList<>();
		this.bidderDatabase = new LinkedList<>();
	}
}
