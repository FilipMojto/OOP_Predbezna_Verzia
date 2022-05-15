package graphical_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/LoadingScene.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Image image = new Image("/pictures/auction.jpg");
			
			primaryStage.getIcons().add(image);
			primaryStage.setResizable(false);
			primaryStage.setTitle("JRA_Auction_Simulator");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
