package userdetails;

public class ActiveUser {
	private static String userName;
	private static int userId;
	private static final String url = "http://127.0.0.1:80";
	
	public static void resetLogin() {
		userName = null;
		userId = 0;
	}
	
	public static void setUser(String newUser) {
		userName = newUser;
	}
	
	public static void setId(int newId) {
		userId = newId;
	}
	
	public static String getUser() {
		return userName;
	}
	
	public static int getId() {
		return userId;
	}
	
	public static String getURL() {
		return url;
	}

	
}
