package application_interface.item.laptop;

public class GamingLaptop extends Laptop {

	private static final long serialVersionUID = 1L;

	public GamingLaptop(String manufacturer, int price) {
		super(manufacturer, price);
		
		super.setType("G");
	}
}
