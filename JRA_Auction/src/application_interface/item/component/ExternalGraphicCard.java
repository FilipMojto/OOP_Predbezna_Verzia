package application_interface.item.component;

public class ExternalGraphicCard extends GraphicCard {
	
	private static final long serialVersionUID = 1L;

	public ExternalGraphicCard(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
		
		super.setType("E");
	}
}
