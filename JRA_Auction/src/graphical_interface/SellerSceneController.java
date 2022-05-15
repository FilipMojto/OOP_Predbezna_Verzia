package graphical_interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application_interface.main_package.DataManagement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SellerSceneController implements Initializable {
	private SceneSwitcher sceneSwitch;
	private DataManagement data;
	
	@FXML private Label logOutPanel;
	
	public void updateData(DataManagement data) {
		this.data = data;
	}
	
    @FXML void logOut(MouseEvent event) throws IOException {
    	this.sceneSwitch.setRoot("/Scenes/LoginScene.fxml");
    	
    	this.sceneSwitch.modifyController((controller) ->{
    		LoginSceneController loginController = (LoginSceneController)controller;
    		loginController.updateData(data);
    	});
    	
    	this.sceneSwitch.switchScene(event);
    }

    @FXML void startAuction(MouseEvent event) {
    	
    }

    @FXML void toDatabase(MouseEvent event) throws IOException {
    	
    	this.sceneSwitch.setRoot("/scenes/BidderDatabaseScene.fxml");
    	
    	this.sceneSwitch.modifyController((controller) ->{
    		BidderDatabaseController databaseController = (BidderDatabaseController)(controller);
    		databaseController.updateData(data);
    	});
    	
    	this.sceneSwitch.switchScene(event);
    }

    @FXML void toInfo(MouseEvent event) {

    }
    
    public void setData(DataManagement data) {
    	this.data = data;
    }
    
	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.sceneSwitch = new SceneSwitcher();
		
	}
}
