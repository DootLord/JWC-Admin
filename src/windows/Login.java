package windows;

import core.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import userdetails.ActiveUser;

public class Login {
	private static Label lblUser;
	private static Label lblPass;
	private static TextField txtUser;
	private static PasswordField txtPass;
	private static Button btnLogin;
	private static Button btnDetails;
	private static HBox hRow1;
	private static HBox hRow2;
	private static VBox layout;
	private static Scene scene;
	private static Insets btnPadding;
	
	public static void initalize() {
		lblUser = new Label();
		lblPass = new Label();
		txtUser = new TextField();
		txtPass = new PasswordField();
		btnLogin = new Button();
		btnDetails = new Button();
		btnPadding = new Insets(5,0,0,20);
	}
	
	public static Scene getScene() {
		initalize();
		
		lblUser.setText("Username:");
		lblPass.setText("Password:");
		lblUser.setPadding(btnPadding);
		lblPass.setPadding(btnPadding);
		txtUser.minWidth(400);
		txtPass.minWidth(400);
		btnLogin.setText("Login");
		btnLogin.setOnAction(e -> {
			ActiveUser.setUser(txtUser.getText());
			ActiveUser.setId(1121);
			Main.setTitle(Control.getSceneTitle());
			Main.getPrimaryStage().setScene(Control.getScene());
		});
		btnDetails.setText("Get Details");
		btnDetails.setOnAction(e -> {
			System.out.println(ActiveUser.getUser());
		});
		
		
		hRow1 = new HBox(10);
		hRow2 = new HBox(12);
		hRow1.getChildren().addAll(lblUser,txtUser);
		hRow2.getChildren().addAll(lblPass,txtPass);
		layout = new VBox(10);
		layout.getChildren().addAll(hRow1,hRow2,btnLogin,btnDetails);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout,300,200);
		
		Main.setTitle("Login");
		return scene;
	}
	
	
	
}
