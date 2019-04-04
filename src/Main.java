
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage){
		try {
			FXMLLoader loader=new FXMLLoader();
			@SuppressWarnings("static-access")
			Parent root= loader.load(getClass().getResource("/LoginPage/LoginPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); 
			primaryStage.setTitle("Student Portal");
			primaryStage.getIcons().add(new Image("/images/Student-3-icon.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
