package application_interface.item.component;

public class ExternalGraphicCard extends GraphicCard {
	
	private static final long serialVersionUID = 1L;

	public ExternalGraphicCard(String manufacturer, int price) {
		super(manufacturer, price);
		
		super.setType("E");
	}
}
