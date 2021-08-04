package com.cognixia.jump.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.cognixia.jump.connection.ConnectionManager;

public class PreparedStatementExample {
	public static void main(String[] args) {
		try( Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select first_name, last_name, credits from student where credits between ? and ?");
				){
			char interested = 'y';
			while(interested == 'y' || interested=='Y') {
				System.out.println("Which class would you like to view?");
				System.out.println("Enter f for freshmen, sp for sophomore, j for junior or sn for senior");
				Scanner input = new Scanner(System.in);
				String classYear = input.nextLine();
				int size = 0;
				ResultSet rs = pstmt.executeQuery();
				switch(classYear) {
				case "f":
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 30);
					System.out.println("Freshmen/man");
					System.out.println("-----------------");
					while(rs.next()) {
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int creds = rs.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
					}
					size = 0;
					if(rs != null) {
						rs.last();
						size = rs.getRow();
					}
					System.out.println("\nTotal: " + size);
					
					
					rs.close();
					break;
				case "sp":
					pstmt.setInt(1,  30);
					pstmt.setInt(2, 60);
					System.out.println("Sophomore(s)");
					System.out.println("-----------------");
					while(rs.next()) {
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int creds = rs.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
					}
					size = 0;
					if(rs != null) {
						rs.last();
						size = rs.getRow();
					}
					System.out.println("\nTotal: " + size);
					
					rs.close();

					break;
					
				case "j":
					pstmt.setInt(1,  60);
					pstmt.setInt(2, 90);
					System.out.println("Junior(s)");
					System.out.println("-----------------");
					while(rs.next()) {
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int creds = rs.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
					}
					size = 0;
					if(rs != null) {
						rs.last();
						size = rs.getRow();
					}
					System.out.println("\nTotal: " + size);					
					rs.close();
					break;
					
				case "sn":
					pstmt.setInt(1, 90);
					pstmt.setDouble(2, Double.POSITIVE_INFINITY);
					System.out.println("Senior(s)");
					System.out.println("-----------------");
					while(rs.next()) {
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int creds = rs.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
					}
					size = 0;
					if(rs != null) {
						rs.last();
						size = rs.getRow();
					}
					System.out.println("\nTotal: " + size);					
					rs.close();
					break;
				default:
					System.out.println("That is not a valid response.");
				}
				System.out.println("\nContinue? Enter Y or y for yes and anything else for no");
				interested = input.next().charAt(0);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
