package application_interface.item.laptop;

import application_interface.main_package.Item;
import other.StringExtension;

public abstract class Laptop extends Item {

	private static final long serialVersionUID = 1L;
	
	transient private StringExtension str;
	
	private String type;
	
	@Override
	protected void setType(String newType) {
		this.str.attachString(newType);
		this.type = this.str.getStringExp();
	}
	
	@Override
	public String getType() {return this.type;}
	
	public Laptop(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
		
		this.str = new StringExtension(null);
		this.type = "L";
	}
}
