package LoginPage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import HomePage.HomePageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPageController implements Initializable{
	
	@FXML
	public VBox vbox1;
	
	@FXML
	public VBox vbox2;
	
	@FXML
	public VBox vbox3;
	 
	@FXML 
	public HBox hbox1;
	
	@FXML
	public HBox hbox2;
	
	@FXML 
	public Text text1;
	
	@FXML 
	public ImageView imageview1;
	
	@FXML
	public ImageView imageview2;
	
	@FXML
	public JFXTextField jfxtextfield1;
	
	@FXML
	public JFXPasswordField jfxpasswordfield1;
	
	@FXML
	public Button button1;
	
	@FXML
	public Button button2;
	LoginPageModel lpg=new LoginPageModel();
	
	@Override
	public void initialize(URL url,ResourceBundle rb)
	{
		if(lpg.conflag==1)
		{
			imageview2.setImage(new Image("/images/checked.png"));
		}
		else
		{
			imageview2.setImage(new Image("/images/error.png"));
		}
		
	}

	public void login(ActionEvent event) throws SQLException, IOException
	{
		String s1=jfxtextfield1.getText();
		String s2=jfxpasswordfield1.getText();
		if(lpg.checkLogin(s1,s2))
		{
			int id=lpg.getId();
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(getClass().getResource("/HomePage/HomePage.fxml"));
			loader.load();
			HomePageController hpc=loader.getController();
			hpc.setId(id);
			Parent root =loader.getRoot();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); 
			primaryStage.setTitle("Welcome to Home Page");
			primaryStage.getIcons().add(new Image("/images/Student-3-icon.png"));
			primaryStage.show();	

		}
		else 
		{
			System.out.print("Not Okay");
		}
		
	}
	

}
