package graphical_interface;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@FunctionalInterface
interface SceneModification {
	public void modify(Object controller);
}

public class SceneSwitcher {
	private FXMLLoader loader;

	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void setRoot(String fxml) throws IOException {
		this.loader = new FXMLLoader(getClass().getResource(fxml));
		this.root = this.loader.load();
	}
	
	public void modifyController(SceneModification controller) {
		controller.modify(this.loader.getController());
	}
	
	public void switchScene(Event event) throws IOException {
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
	}
}
