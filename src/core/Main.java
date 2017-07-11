package core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import windows.Login;


public class Main extends Application{
	private static Stage stage;
	String urlString = "http://127.0.0.1:3542/test";
	
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
	
	public void setPrimaryStage(Stage pStage) {
		stage = pStage;
	}
	
	
	
	public void callServer(ActionEvent event) throws IOException {
		String output;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(urlString);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		response.close();
	}
	





}
