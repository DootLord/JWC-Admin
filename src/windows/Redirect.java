package windows;

import core.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import userdetails.ActiveUser;

public class Redirect {
	private static Button btnChange;
	private static VBox layout;
	private static Scene scene;
	
	
	public static Scene getScene() {
		btnChange = new Button();
		
		btnChange.setText("Back!");
		btnChange.setOnAction(e -> {
			System.out.println(ActiveUser.getUser());
			Main.getPrimaryStage().setScene(Login.getScene());
		});
		
		layout = new VBox(10);
		layout.getChildren().add(btnChange);
		layout.setAlignment(Pos.CENTER);
		
		scene = new Scene(layout,500,500);
		return scene;
	}
	

}
