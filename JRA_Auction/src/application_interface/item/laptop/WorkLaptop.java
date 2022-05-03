package application_interface.item.laptop;

public class WorkLaptop extends Laptop {
	
	private static final long serialVersionUID = 1L;

	public WorkLaptop(String manufacturer, int price) {
		super(manufacturer, price);
		
		super.setType("W");
	}
}
