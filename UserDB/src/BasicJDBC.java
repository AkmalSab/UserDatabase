import java.sql.*;

public class BasicJDBC {

	public BasicJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean findAndDisplay(Statement stmt, int id) throws SQLException {
		boolean idFound;
		
		String sqlStatement = "SELECT * FROM persons WHERE ID ="+id+"";
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		if(result.next()) {
			idFound = true;
		}else {
			idFound = false;
		}
		result.close();
		return idFound;
	}
	
	public void search(Statement stmt, int id) throws SQLException{
		String sqlStatement = "SELECT * FROM persons WHERE ID = "+id+"";
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		if(result.next()) {
			System.out.println("Name:"+result.getString(2));
			System.out.println("Email:"+result.getString(3));
			System.out.println("Age:"+result.getString(4));
		}
		
		else {
			System.out.println("The id was not found");
		}
		result.close();
		stmt.close();
	}
	
	public void viewAll(Statement stmt) throws SQLException{
		String sqlStatement = "SELECT * FROM persons";
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		while (result.next()) {
			System.out.printf("%-5d %-25s %-25s %d\n", result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
		}
		result.close();
	}
	
	public void updateAge(Statement stmt, int id,int age) throws SQLException{
		String sqlStatement = "UPDATE persons SET Age ="+age+" WHERE ID = "+id+"";
		
		int rows = stmt.executeUpdate(sqlStatement);
		
		System.out.println(rows + " row(s) updated");
	}
	
	public void insert(Statement stmt, String name,String email, int age) throws SQLException{
		String sqlStatement = "INSERT INTO persons (Name,Email,Age) VALUES ('"+name+"','"+email+"','"+age+"')";
		
		int rows = stmt.executeUpdate(sqlStatement);
		
		System.out.println(rows + " row(s) added to the table");
	}
	
	public void delete(Statement stmt, int id) throws SQLException{
		String sqlStatement = "DELETE FROM persons WHERE ID = "+id+"";
		
		int rows = stmt.executeUpdate(sqlStatement);
		
		System.out.println(rows + " row(s) deleted");
	}
	
	

}
