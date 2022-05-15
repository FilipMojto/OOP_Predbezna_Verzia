package application_interface.item.component;

public abstract class GraphicCard extends Component {
	
	private static final long serialVersionUID = 1L;

	public GraphicCard(String manufacturer, String name, int price) {
		super(manufacturer, name, price);
	}

}
