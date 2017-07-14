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

import elements.NumberTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import popup.AlertBox;
import userdetails.ActiveUser;

public class Control {
	private static Button btnNew;
	private static Button btnDelete;
	private static Button btnNewAdmin;
	private static Button btnRename;
	private static Button btnPoint;
	private static TextField txtUser;
	private static TextField txtAdminUser;
	private static TextField txtAdminPass;
	private static TextField txtRenameOld;
	private static TextField txtRenameNew;
	private static TextField txtUserPnt;
	private static NumberTextField txtPoint;
	private static Label lblUser;
	private static Label lblAdmin;
	private static Label lblRename;
	private static Label lblPoint;
	private static HBox userBtnRow;
	private static HBox row1Layout;
	private static HBox row2Layout;
	private static VBox layout;
	private static VBox adminLayout;
	private static VBox renameLayout;
	private static VBox pointLayout;
	private static VBox userLayout;
	private static Scene scene;
	private static String borderStyle;
	
	public static void initalize(){
		borderStyle = "-fx-border: 12px solid;" + "-fx-border-color:black;";
		
		// New/Delete User
		lblUser = new Label("User Add/Delete");
		lblUser.setPadding(new Insets(0,0,10,0));
		
		txtUser = new TextField();
		txtUser.setPromptText("User");
		
		btnNew = new Button("New");
		btnNew.setOnAction(e -> newUser(txtUser.getText()));
		btnDelete = new Button("Delete");
		btnDelete.setOnAction(e -> deleteUser(txtUser.getText()));
		
		userBtnRow = new HBox();
		userBtnRow.setPadding(new Insets(10,0,0,0));
		userBtnRow.setSpacing(60);
		userBtnRow.getChildren().addAll(btnNew,btnDelete);
		
		userLayout = new VBox();
		userLayout.setAlignment(Pos.TOP_CENTER);
		userLayout.setPadding(new Insets(10));
		userLayout.setStyle(borderStyle + "-fx-background-color: #b5f4c1");
		userLayout.getChildren().addAll(lblUser,txtUser,userBtnRow);
		
		// User Rename
		lblRename = new Label("Rename User");
		
		txtRenameOld = new TextField();
		txtRenameOld.setPromptText("Current Name");
		txtRenameNew = new TextField();
		txtRenameNew.setPromptText("New Name");
		
		btnRename = new Button("Rename");
		btnRename.setOnAction(e -> renameUser(txtRenameOld.getText(), txtRenameNew.getText()));
		
		renameLayout = new VBox();
		renameLayout.setAlignment(Pos.CENTER);
		renameLayout.setPadding(new Insets(10));
		renameLayout.setSpacing(3);
		renameLayout.setStyle(borderStyle + "-fx-background-color: #b5f4f1");
		renameLayout.getChildren().addAll(lblRename,txtRenameOld,txtRenameNew,btnRename);
		
		// New Admin
		lblAdmin = new Label("Create Admin");
		
		btnNewAdmin = new Button("Create Admin");
		btnNewAdmin.setOnAction(e -> makeAdmin(txtAdminUser.getText(), txtAdminPass.getText()));
		
		txtAdminUser = new TextField();
		txtAdminUser.setPromptText("Username");
		txtAdminPass = new TextField();
		txtAdminPass.setPromptText("Password");
		
		adminLayout = new VBox();
		adminLayout.setAlignment(Pos.TOP_CENTER);
		adminLayout.setPadding(new Insets(10));
		adminLayout.setSpacing(3);
		adminLayout.setStyle(borderStyle + "-fx-background-color: #f4b5b5");
		adminLayout.getChildren().addAll(lblAdmin,txtAdminUser,txtAdminPass,btnNewAdmin);
		
		// Point Alter
		lblPoint = new Label ("Point Modification");
		
		txtUserPnt = new TextField();
		txtUserPnt.setPromptText("User");
		txtPoint = new NumberTextField();
		txtPoint.setPromptText("Points");
		
		btnPoint = new Button("Set Score");
		btnPoint.setOnAction(e -> alterPoints(txtUserPnt.getText(),Integer.parseInt(txtPoint.getText())));
		
		pointLayout = new VBox();
		pointLayout.setAlignment(Pos.TOP_CENTER);
		pointLayout.setPadding(new Insets(10));
		pointLayout.setSpacing(3);
		pointLayout.setStyle(borderStyle + "-fx-background-color: #f4f2b5");
		pointLayout.getChildren().addAll(lblPoint,txtUserPnt,txtPoint,btnPoint);
		
		// Overall Layout
		row1Layout = new HBox();
		row1Layout.setPadding(new Insets(15,12,5,12));
		row1Layout.setSpacing(5);
		row1Layout.getChildren().addAll(adminLayout,renameLayout);
		
		row2Layout = new HBox();
		row2Layout.setSpacing(5);
		row2Layout.setPadding(new Insets(15,12,0,12));
		row2Layout.getChildren().addAll(userLayout, pointLayout);
		
		layout = new VBox();
		layout.getChildren().addAll(row1Layout,row2Layout);
		
		scene = new Scene(layout,375,300);
	}
	
	
	public static Scene getScene() {
		initalize();
		return scene;
	}
	
	public static String getSceneTitle() {
		return "JWC Control Panel - " + ActiveUser.getUser();
	}
	
	public static void newUser(String user) {
		if(user.equals("")) {
			AlertBox.display("No Text Found!!", "Enter a user's name into the user text field!");
			
		}
		/*
		 * HTTP Request Goes here
		 */
		System.out.println("New user " + user + " created!");
	}
	
	public static void deleteUser(String user) {
		System.out.println("User " + user + " deleted!");
	}
	
	public static void makeAdmin(String user, String password) {
		
	}
	
	public static void renameUser(String user, String newName) {
		
		System.out.println("User " + user + " now renamed to " + newName);
	}
	
	
	public static void alterPoints(String user, int newPoints) {
		System.out.println("User " + user + " score set to " + newPoints);
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
