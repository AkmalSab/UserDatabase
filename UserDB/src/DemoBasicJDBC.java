import java.util.Scanner;
import java.sql.*;

public class DemoBasicJDBC {

	public DemoBasicJDBC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		DatabaseConnection dc = new DatabaseConnection();
		
		BasicJDBC db = new BasicJDBC();
		
		int menu, id, age;
		String name, email;
		char proceed = 'y';
		
		try(Connection conn = dc.getConnection()){
			System.out.println("Database successfully connected!\n");
			
			Statement stmt = conn.createStatement();
			
		do {
				System.out.println("1. Search");
				System.out.println("2. Update age");
				System.out.println("3. Insert");
				System.out.println("4. Delete");
				System.out.println("Please select menu (1/2/3/4):");
				menu = input.nextInt();
				input.nextLine();
				
				if(menu == 1) {
					System.out.println("Enter ID: ");
					id = input.nextInt();
					
					db.search(stmt, id);
				}
				else if(menu == 2) {
					db.viewAll(stmt);
					System.out.println("Enter ID to update his age: ");
					id = input.nextInt();
					
					if(db.findAndDisplay(stmt, id)) {
						System.out.println("Enter new age: ");
						age = input.nextInt();
						
						db.updateAge(stmt, id, age);
					}
					else {
						System.out.println("The id was not found");
					}
				}
				else if (menu == 3) {
					System.out.println("Enter the name: ");
					name = input.nextLine();
					System.out.println("Enter the age: ");
					age = id = input.nextInt();
					System.out.println("Enter the email: ");
					email = input.nextLine();
					
					db.insert(stmt, name, email, age);
				}
				else if (menu == 4) {
					db.viewAll(stmt);
					System.out.println("Enter ID to delete: ");
					id = input.nextInt();
					input.nextLine();
					
					if (db.findAndDisplay(stmt, id)) {
						db.delete(stmt, id);
					}
					else {
						System.out.println("The ID was not found");
					}
				}
				else {
					System.out.println("Sorry you key in the wrong menu");
				}
				System.out.println("\nDo you want to continue(y for yes,n for no):");
				proceed = input.next().charAt(0);
			}while (proceed =='y'|| proceed=='Y');
			System.out.println("\nThank you.");
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
