package graphical_interface;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application_interface.Bidder;
import application_interface.ObjectInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BidderSceneController implements Initializable {
	private Stage stage;
	private Scene scene;
	
	private ObjectInput objIn;
	
	@FXML private TableView<Bidder> bidderOverview;
	@FXML private TableColumn<Bidder, String> nameColumn;
	@FXML private TableColumn<Bidder, Character> priviligeColumn;
	
	ObservableList<Bidder> bidderList = FXCollections.observableArrayList();
	
	@FXML
	Button backButton = new Button();
	
	public void returnToPreviousScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/scenes/MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			this.objIn = new ObjectInput(new File("src/files/serialized/personal_data.ser"));
			
			while(true) {
				Bidder bidder = (Bidder)this.objIn.deserializeObject();
				this.bidderList.add(bidder);
			}
		}
		catch(EOFException e) {}
		catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		this.nameColumn.setCellValueFactory(new PropertyValueFactory<Bidder, String>("name"));
		this.priviligeColumn.setCellValueFactory(new PropertyValueFactory<Bidder, Character>("privilige"));
		
		this.bidderOverview.setItems(bidderList);
	}
	
	
}