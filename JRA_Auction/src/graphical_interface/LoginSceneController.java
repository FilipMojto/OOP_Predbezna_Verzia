package graphical_interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application_interface.main_package.DataManagement;
import error_package.Warning;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginSceneController implements Initializable {
	private SceneSwitcher sceneSwitch;
	private String privilige[] = {"Administrator", "Seller", "VIP_Bidder", "Bidder"};
	private DataManagement data;
	
	@FXML private ChoiceBox<String> accountBox;
    @FXML private TextField nameField;
    @FXML private PasswordField passwordField;
    @FXML private Label registerLabel;
    @FXML private Label loginLabel;
    @FXML private Label warning;
    
    private boolean checkInput() {
    	if(this.nameField.getText().isEmpty()) {
			this.setWarning(Warning.MISSING_NAME_ERROR);
			return false;
		}
		
		if(this.passwordField.getText().isEmpty()) {
			this.setWarning(Warning.MISSING_PASSWORD_ERROR);
			return false;
		}
		
		return true;
    }
    
    private boolean checkInputValidity() {
    	if(this.data.getPersonDatabase().containsKey(this.nameField.getText()) == false) {
    		this.setWarning(Warning.NAME_NOT_REGISTRED_ERROR);
    		return false;
    	}
    	
    	if(this.data.getPersonDatabase().containsValue(this.passwordField.getText()) == false) {
    		this.setWarning(Warning.INVALID_PASSWORD_ERROR);
    		return false;
    	}
    	
    	return true;
    }
    
    public void setWarning(String warning) {
    	this.warning.setVisible(true);
    	this.warning.setText(warning);
    	this.warning.setAlignment(Pos.CENTER);
    }
    
    @FXML void login(MouseEvent event) throws IOException {
    	
    	if(this.accountBox.getValue().equals(this.accountBox.getItems().toArray()[1])) {
    		if(this.checkInput() == false) {return;}
    		if(this.checkInputValidity() == false) {return;}
    		
    		this.sceneSwitch.setRoot("/Scenes/SellerScene.fxml");
    		
    		this.sceneSwitch.modifyController((controller) ->{
    			SellerSceneController sellerController = (SellerSceneController)controller;
    			sellerController.updateData(data);
    		});
    		
    		this.sceneSwitch.switchScene(event);
    	}
    	else if(this.accountBox.getValue().equals(this.accountBox.getItems().toArray()[3])) {
    		if(this.checkInput() == false) {return;}
    		if(this.checkInputValidity() == false) {return;}
    		
    		this.sceneSwitch.setRoot("/Scenes/BidderScene.fxml");
    		
    		this.sceneSwitch.modifyController((controller) ->{
    			BidderSceneController bidderController = (BidderSceneController)controller;
    			bidderController.updateData(data);
    		});
    		
    		this.sceneSwitch.switchScene(event);
    	}
    }
    
    public void updateData(DataManagement data) {
    	this.data = data;
    }
    
    @FXML void register(MouseEvent event) throws IOException {
    	this.sceneSwitch.setRoot("/scenes/RegisterScene.fxml");
    	this.sceneSwitch.modifyController((controller) -> {
    		RegisterSceneController contr = (RegisterSceneController)controller;
    		contr.updateData(this.data);
    	});
    	
    	this.sceneSwitch.switchScene(event);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.sceneSwitch = new SceneSwitcher();
		
		this.accountBox.getItems().addAll(privilige);
		this.accountBox.getSelectionModel().select(3);
		
	}
	
}