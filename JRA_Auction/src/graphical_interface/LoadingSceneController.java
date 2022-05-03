package graphical_interface;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import application_interface.Bidder;
import application_interface.FileScanner;
import application_interface.ItemData;
import application_interface.FileOutput;
import application_interface.VIP_Bidder;
import application_interface.item.component.ExternalGraphicCard;
import application_interface.item.component.InternalGraphicCard;
import application_interface.item.laptop.GamingLaptop;
import application_interface.item.laptop.WorkLaptop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class LoadingSceneController implements Initializable {
	private Stage stage;
	private Scene scene;
	
	private FileOutput fileOut;
	
	@FXML private ProgressBar loadingBar = new ProgressBar();
	@FXML private Label loadingLabel = new Label();
	@FXML private Label continueLabel = new Label();
	@FXML private Button continueButton = new Button();
	
	@FXML public void toMainScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/scenes/MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.fileOut = new FileOutput(new File("src/files/original/personal_data.txt"), new File("src/files/serialized/personal_data.ser"));
			
			this.fileOut.serializeFile((FileOutput objOut, FileScanner fileScan) -> {
				try {
					while(true) {
						switch(fileScan.scanLine().charAt(0)) {
							case 'B': objOut.writeStream(new Bidder(fileScan.scanLine(), 'B')); break;
							case 'V': objOut.writeStream(new VIP_Bidder(fileScan.scanLine(), 'V')); break;
							default: throw new InvalidObjectException(error.FileError.INVALID_DATA_ERROR);
						}
					}
				}
				catch(IOException | NoSuchElementException e) {}
			});
			
			this.fileOut.closeStream();
			
			this.fileOut = new FileOutput(new File("src/files/original/storage.txt"), new File("src/files/serialized/storage.ser"));
			
			this.fileOut.serializeFile((FileOutput objOut, FileScanner fileScan) -> {
				try {
					ItemData itemData = new ItemData(4, fileScan);
					
					while(true) {
						itemData.gatherData();
						
						fileScan.scanLine();
						
						if(itemData.getData().get(2).equals("LG")) {
							objOut.writeStream(new GamingLaptop(itemData.getData().get(0), Integer.parseInt(itemData.getData().get(3))));
						}
						else if(itemData.getData().get(2).equals("LW")) {
							objOut.writeStream(new WorkLaptop(itemData.getData().get(0), Integer.parseInt(itemData.getData().get(3))));
						}
						else if(itemData.getData().get(2).equals("CCI")) {
							objOut.writeStream(new InternalGraphicCard(itemData.getData().get(0), Integer.parseInt(itemData.getData().get(3))));
						}
						else if(itemData.getData().get(2).equals("CCE")) {
							objOut.writeStream(new ExternalGraphicCard(itemData.getData().get(0), Integer.parseInt(itemData.getData().get(3))));
						}
						else {
							throw new InvalidObjectException(error.FileError.INVALID_DATA_ERROR);
						}
					}
					
				} 
				catch(NoSuchElementException e) {}
				catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			this.fileOut.closeStream();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.loadingLabel.setVisible(false);
		this.loadingBar.setVisible(false);
	}
	
}