package application_interface;

import java.io.Serializable;

public abstract class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String manufacturer;
	private int price;
	
	public abstract String getType();
	protected abstract void setType(String newType);
	
	public String getManufacturer() {return this.manufacturer;}
	public int getPrice() {return this.price;}
	
	public Item(String manufacturer, int price) {		
		this.manufacturer = manufacturer;
		this.price = price;
	}
}
