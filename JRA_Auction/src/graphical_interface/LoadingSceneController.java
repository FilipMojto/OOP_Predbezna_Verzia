package graphical_interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import error_package.Warning;

import application_interface.main_package.Administrator;
import application_interface.main_package.DataManagement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import other.TaskTiming;

public class LoadingSceneController implements Initializable {
	private SceneSwitcher sceenSwitch;
	private DataManagement data;
	private TaskTiming timeTask;
	
	private Stage stage;
	
    @FXML private Label loadingLabel = new Label();

    @FXML private ProgressBar progressBar = new ProgressBar();

    @FXML private Label toRegisterLabel = new Label();
    @FXML private Label toLoginLabel = new Label();
    
    @FXML private void toRegister(MouseEvent event) throws IOException {
    	this.sceenSwitch.setRoot("/scenes/RegisterScene.fxml");
    	
    	this.sceenSwitch.modifyController((controller) ->{
    		
    		RegisterSceneController registerController = (RegisterSceneController)controller;
    		
    		registerController.updateData(this.data);
    		registerController.addAccount("Administrator");
    		registerController.fromAccountsSetFirst(0);
    		registerController.setWarning(Warning.ADMIN_NOT_INITIALIZED_ERROR);
    		
    	});
    	this.sceenSwitch.switchScene(event);
    }
    
    @FXML private void toLogin(MouseEvent event) throws IOException {
    	this.sceenSwitch.setRoot("/scenes/LoginScene.fxml");
    	
    	this.sceenSwitch.modifyController((controller) ->{
    		LoginSceneController loginController = (LoginSceneController)controller;
    	
    		loginController.updateData(this.data);
    		
    	});
    	
    	this.sceenSwitch.switchScene(event);
    }
    
    public DataManagement getData() {
    	return this.data;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.sceenSwitch = new SceneSwitcher();
		
		this.data = new DataManagement();
		this.data.getPersonalData();
		
		this.timeTask = new TaskTiming(()->{
			this.progressBar.setVisible(false);
			this.loadingLabel.setVisible(false);
			
			if(this.data.getAdmin() == null) {this.toRegisterLabel.setVisible(true);}
			else {
				this.toLoginLabel.setVisible(true);
			}
		});
		
		this.timeTask.startDelay(3000);
		
	}
}
