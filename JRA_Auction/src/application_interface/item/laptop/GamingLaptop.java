package application_interface.item.laptop;

public class GamingLaptop extends Laptop {

	private static final long serialVersionUID = 1L;

	public GamingLaptop(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
		
		super.setType("G");
	}
}
