package HomePage;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HomePageController {
	
	@FXML
	public VBox vbox1;
	@FXML
	public VBox vbox2;
	@FXML
	public VBox vbox3;
	@FXML
	public VBox vbox4;
	@FXML
	public VBox vbox5;
	@FXML
	public ImageView imageview1;
	@FXML
	public AnchorPane anchorpane1;
	@FXML
	public Button jfxbutton1;
	@FXML
	public Button jfxbutton2;
	@FXML
	public Button jfxbutton3;
	@FXML
	public Button jfxbutton4;
	@FXML
	public Button jfxbutton5;
	@FXML
	public Button jfxbutton6;
	@FXML
	public Label label1;
	@FXML
	public Label label2;
	@FXML
	public Label label3;
	@FXML
	public Label label4;
	@FXML
	public Label label5;
	@FXML
	public Label label6;
	@FXML
	public Label label7;
	@FXML
	public Label label8;
	@FXML
	public Label label9;
	@FXML
	public Label label10;
	@FXML
	public Label label11;
	@FXML
	public Label label12;
	
	int ID;
	HomePageModel hpm=new HomePageModel();
	
	public void setId(int id) throws SQLException, IOException
	{
		ID=id;
		hpm.getID(ID);
		hpm.setHomePage();
		label7.setText(hpm.firstname.toUpperCase()+" "+hpm.middlename.toUpperCase()+" "+hpm.lastname.toUpperCase());
		label8.setText(hpm.department.toUpperCase());
		label9.setText(hpm.semester);
		label10.setText(hpm.studentno);
		label11.setText(hpm.parentno);
		label12.setText(hpm.birthdate);
		Image img=new Image(hpm.studentphoto);
		imageview1.setImage(img);
		
	}
	
	public void dashboardclick(ActionEvent event) throws IOException, SQLException
	{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(getClass().getResource("/HomePage/HomePage.fxml"));
		loader.load();
		HomePageController hpc=loader.getController();
		hpc.setId(ID);
		Parent root =loader.getRoot();
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("/images/Student-3-icon.png"));
		primaryStage.setTitle("Welcome to Home Page");
		primaryStage.setScene(scene); 
		primaryStage.show();	
	}
	
	public void logoutclick(ActionEvent event) throws IOException
	{
		ID=0;
		hpm.ID=0;
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(getClass().getResource("/LoginPage/LoginPage.fxml"));
		loader.load();
		Parent root =loader.getRoot();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene); 
		primaryStage.getIcons().add(new Image("/images/Student-3-icon.png"));
		primaryStage.setTitle("Student Portal");
		primaryStage.show();
	}
	
	
}
