package application_interface.item.laptop;

public class WorkLaptop extends Laptop {
	
	private static final long serialVersionUID = 1L;

	public WorkLaptop(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
		
		super.setType("W");
	}
}
