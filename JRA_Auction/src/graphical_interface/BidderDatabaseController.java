package graphical_interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import other.PriviligeLevels.BidderPrivilige;

import application_interface.main_package.Bidder;
import application_interface.main_package.DataManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BidderDatabaseController implements Initializable {
	private SceneSwitcher sceneSwitch;
	private DataManagement data;
	private ObservableList<Bidder> bidders;
	
	@FXML private TableView<Bidder> bidderOverview;

    @FXML private TableColumn<Bidder, String> nameColumn;

    @FXML private TableColumn<Bidder, BidderPrivilige> priviligeColumn;
    
    @FXML private void toMainMenu(ActionEvent event) throws IOException {
    	this.sceneSwitch.setRoot("/scenes/SellerScene.fxml");
    	
    	this.sceneSwitch.modifyController((controller) -> {
    		SellerSceneController sellerController = (SellerSceneController)controller;
    		sellerController.updateData(data);
    	});
    	
    	this.sceneSwitch.switchScene(event);
    }
    
	public void updateData(DataManagement data) {
    	this.data = data;
    	this.bidders = FXCollections.observableArrayList();
    	
    	for(int i = 0; i < this.data.getVIP_BidderDatabase().size(); i++) {
    		bidders.add(this.data.getVIP_BidderDatabase().get(i));
    	}
    	
    	for(int i = 0; i < this.data.getBidderDatabase().size(); i++) {
    		bidders.add(this.data.getBidderDatabase().get(i));
    	}
    	
    	this.nameColumn.setCellValueFactory(new PropertyValueFactory<Bidder, String>("Name"));
    	this.priviligeColumn.setCellValueFactory(new PropertyValueFactory<Bidder, BidderPrivilige>("Privilige"));
    	
    	this.bidderOverview.setItems(bidders);
   
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.sceneSwitch = new SceneSwitcher();
		
	}

}

