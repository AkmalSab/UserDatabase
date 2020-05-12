import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	String driver,dbName,connectionURL,username,password;
	
	public DatabaseConnection() {
		driver = "com.mysql.cj.jdbc.Driver";
		connectionURL = "jdbc:mysql://localhost:3306/";
		dbName = "mydb";
		username = "root";
		password = "";
	}
	
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(connectionURL+dbName+"?serverTimezone=UTC",username,password);
		return connection;
	}

	public static void main(String[] args) {

		DatabaseConnection db = new DatabaseConnection();
		try (Connection conn = db.getConnection()){
			if(conn != null) {
				System.out.println("Database Successfully connected");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
