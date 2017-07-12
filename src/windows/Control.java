package windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import userdetails.ActiveUser;

public class Control {
	private static Button btnGet;
	private static Button btnSet;
	private static Button btnNew;
	private static Button btnDelete;
	private static TextField txtTest;
	private static TextField txtNewUser;
	private static HBox userBtnRow;
	private static HBox row1Layout;
	private static HBox row2Layout;
	private static VBox layout;
	private static VBox pointLayout;
	private static VBox userLayout;
	private static Scene scene;
	
	public static void initalize(){
		// Points Pannel
		btnGet = new Button("Get Response");
		btnSet = new Button("Update Server");
		txtTest = new TextField();
		
		btnGet.setOnAction(e -> {
			try {
				getTempSVR(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		btnSet.setOnAction(e ->{
			try {
				setTempSVR(e,txtTest.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		pointLayout = new VBox();
	    pointLayout.setStyle("-fx-background-color:blue");
		pointLayout.setPadding(new Insets(10));
		pointLayout.setSpacing(10);
		pointLayout.setPrefHeight(0.2);
		pointLayout.setAlignment(Pos.TOP_CENTER);
		pointLayout.getChildren().addAll(btnGet,btnSet,txtTest);
		
		// User Panel
		txtNewUser = new TextField();
		btnNew = new Button("New");
		btnDelete = new Button("Delete");
		userBtnRow = new HBox();
		userBtnRow.setSpacing(60);
		
		btnNew.setOnAction(e -> System.out.println("New Press"));
		btnDelete.setOnAction(e -> System.out.println("Delete Press"));
		
		userBtnRow.getChildren().addAll(btnNew,btnDelete);
		userLayout = new VBox();
		userLayout.setStyle("-fx-background-color:green");
		userLayout.setPadding(new Insets(10));
		userLayout.setPrefHeight(0);
		userLayout.setAlignment(Pos.TOP_CENTER);
		userLayout.getChildren().addAll(txtNewUser,userBtnRow);
		
		
		// Overall Layout
		row1Layout = new HBox();
		row1Layout.setStyle("-fx-background-color:pink");
		row1Layout.setPadding(new Insets(15,12,15,12));
		
		row1Layout.getChildren().addAll(pointLayout);
		
		row2Layout = new HBox();
		row2Layout.setStyle("-fx-background-color:purple");
		row2Layout.setPadding(new Insets(15,12,15,12));
		row2Layout.getChildren().addAll(userLayout);
		
		layout = new VBox();
		layout.getChildren().addAll(row1Layout,row2Layout);
		
		scene = new Scene(layout,500,500);
		
	}
	
	
	public static Scene getScene() {
		initalize();
		
		
		
		
		return scene;
	}
	

	public static void getTempSVR(ActionEvent event) throws IOException {
		String output;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(ActiveUser.getURL() + "/temp");
		CloseableHttpResponse response = httpclient.execute(httpGet);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		response.close();
	}
	
	public static void setTempSVR(ActionEvent event, String message) throws IOException{
		String url = ActiveUser.getURL() + "/temp";
		String resp;
		
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("newString", message));
		
		post.setEntity(new UrlEncodedFormEntity(data));
		
		HttpResponse response = client.execute(post);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while((resp = rd.readLine()) != null) {
			System.out.println(resp);
		}
	}
	

}
