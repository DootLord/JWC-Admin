package core;
import javafx.application.Application;
import javafx.stage.Stage;
import windows.Login;


public class Main extends Application{
	private static Stage stage;
	
	public static void main(String args[]) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setScene(Login.getScene());
		primaryStage.show();
		
	}
	
	public static Stage getPrimaryStage() {
		return stage;
	}
	
	public static void setTitle(String title) {
		stage.setTitle(title);
	}
	
	public void setPrimaryStage(Stage pStage) {
		stage = pStage;
	}
	
	
	
	





}
