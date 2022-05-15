package application_interface.main_package;

import java.io.Serializable;

public abstract class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String manufacturer;
	private String name;
	private int price;
	
	public abstract String getType();
	protected abstract void setType(String newType);
	
	public String getManufacturer() {return this.manufacturer;}
	public int getPrice() {return this.price;}
	
	public Item(String manufacturer,String name, int price) {		
		this.manufacturer = manufacturer;
		this.name = name;
		this.price = price;
	}
}
