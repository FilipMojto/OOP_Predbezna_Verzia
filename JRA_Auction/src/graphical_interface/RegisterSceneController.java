package graphical_interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application_interface.main_package.Administrator;
import application_interface.main_package.Bidder;
import application_interface.main_package.DataManagement;
import application_interface.main_package.Seller;
import application_interface.main_package.VIP_Bidder;
import error_package.Warning;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegisterSceneController implements Initializable {
	private SceneSwitcher sceneSwitch;
	private DataManagement personalData;
	
	@FXML private Label RegisterLabel = new Label();
    @FXML private ChoiceBox<String> accountBox = new ChoiceBox<>();
    @FXML private TextField nameField = new TextField(); 
    @FXML private PasswordField passwordField = new PasswordField();
    @FXML private Label loginLabel = new Label();
    @FXML private Label warning = new Label();
    
    public void addAccount(String account) {
    	this.accountBox.getItems().add(account);
    }
    
    public void updateData(DataManagement personalData) {
    	this.personalData = personalData;
    }
    
    public void fromAccountsSetFirst(int index) {
    	
    	this.accountBox.getSelectionModel().select(index);
    }
    
    public void setWarning(String warning) {
    	this.warning.setVisible(true);
    	this.warning.setText(warning);
    	this.warning.setAlignment(Pos.CENTER);
    }
    
    
    public ChoiceBox<String> getAccountBox() {
    	return this.accountBox;
    }
    
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
    
    private boolean checkInputOriginality() {
    	if(this.personalData.getPersonDatabase().containsKey(this.nameField.getText())) {
    		this.setWarning(Warning.NAME_ALREADY_USED_ERROR);
    		return false;
    	}
    	
    	if(this.personalData.getPersonDatabase().containsValue(this.passwordField.getText())) {
    		this.setWarning(Warning.PASSWORD_ALREADY_USED_ERROR);
    		return false;
    	}
    	
    	return true;
    }
    
    @FXML void login(MouseEvent event) throws IOException {
    	this.sceneSwitch.setRoot("/scenes/LoginScene.fxml");
    	
    	this.sceneSwitch.modifyController((controller) ->{
    		LoginSceneController loginController = (LoginSceneController)controller;
    		loginController.updateData(personalData);
    	});
    	
    	this.sceneSwitch.switchScene(event);
    }

    @FXML void register(MouseEvent event) throws IOException {
    
    	if(this.accountBox.getValue().equals(this.accountBox.getItems().toArray()[0])){
    		
    		if(this.personalData.getAdmin() != null) {
    			this.setWarning(Warning.ADMIN_INITIALIZED_ERROR);
    			return;
    		}
    		
    		if(this.checkInput() == false) {return;}
    		
    		this.personalData.updatePerson(Administrator.getInstance(this.nameField.getText(), this.passwordField.getText()));
    		this.personalData.getPersonalData();
    	}
    	else if(this.accountBox.getValue().equals(this.accountBox.getItems().toArray()[1])){
    		
    		if(this.checkInput() == false) {return;}
    		else if(this.checkInputOriginality() == false) {return;}
    		
    		this.personalData.updatePerson(new Seller(this.nameField.getText(), this.passwordField.getText()));
    		this.personalData.getPersonalData();
    	}
    	else if(this.accountBox.getValue().equals(this.accountBox.getItems().toArray()[2])) {
    		
    		if(this.checkInput() == false) {return;}
    		else if(this.checkInputOriginality() == false) {return;}
    		
    		this.personalData.updatePerson(new VIP_Bidder(this.nameField.getText(), this.passwordField.getText()));
    		this.personalData.getPersonalData();
    	}
    	else {
    		
    		if(this.checkInput() == false) {return;}
    		else if(this.checkInputOriginality() == false) {return;}
    		
    		this.personalData.updatePerson(new Bidder(this.nameField.getText(), this.passwordField.getText()));
    		this.personalData.getPersonalData();
    	}
    	
    	//this.sceneSwitch.setRoot("/scenes/RegisterScene.fxml");
    	//this.sceneSwitch.switchScene(event);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.warning.setVisible(false);
		this.sceneSwitch = new SceneSwitcher();
		
		if(this.accountBox.getItems().isEmpty()) {
    		this.accountBox.getItems().add("Administrator");
    		this.accountBox.getItems().add("Seller");
    		this.accountBox.getItems().add("VIP_Bidder");
    		this.accountBox.getItems().add("Bidder");
    		
    		this.fromAccountsSetFirst(3);
    	}
	}
}
