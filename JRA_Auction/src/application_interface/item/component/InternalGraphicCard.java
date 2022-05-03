package application_interface.item.component;

public class InternalGraphicCard extends GraphicCard {
	
	private static final long serialVersionUID = 1L;

	public InternalGraphicCard(String manufacturer, int price) {
		super(manufacturer, price);
		
		super.setType("I");
	}
}
