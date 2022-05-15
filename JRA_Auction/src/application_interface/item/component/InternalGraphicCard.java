package application_interface.item.component;

public class InternalGraphicCard extends GraphicCard {
	
	private static final long serialVersionUID = 1L;

	public InternalGraphicCard(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
		
		super.setType("I");
	}
}
