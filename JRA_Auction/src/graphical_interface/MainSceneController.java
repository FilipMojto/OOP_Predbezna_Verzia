package graphical_interface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainSceneController {
	private Stage stage;
	private Scene scene;
	
	@FXML
	private Button but1;
	@FXML
	private Button exitButton;
		
	@FXML
	public void setStorage(ActionEvent event) {
		but1.setOpacity(1);
	}
	
	@FXML
	public void setBidders(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/scenes/BidderScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void exit(ActionEvent event) {
		
		Stage stage = (Stage) exitButton.getScene().getWindow();
		stage.close();
	}
}
