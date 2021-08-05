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
				int count = 0;
				switch(classYear) {
				case "f":
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 30);
					ResultSet rs = pstmt.executeQuery();
					count = 0;
					System.out.println("Freshmen/man");
					System.out.println("-----------------");
					while(rs.next()) {
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int creds = rs.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
						count++;
					}
				
					System.out.println("\nTotal: " + count);
					
					
					rs.close();
					break;
				case "sp":
					pstmt.setInt(1,  30);
					pstmt.setInt(2, 60);
					ResultSet rs1= pstmt.executeQuery();
					count = 0;
					System.out.println("Sophomore(s)");
					System.out.println("-----------------");
					while(rs1.next()) {
						String firstName = rs1.getString("first_name");
						String lastName = rs1.getString("last_name");
						int creds = rs1.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
						count++;
					}
					
					System.out.println("\nTotal: " + count);
					
					rs1.close();

					break;
					
				case "j":
					pstmt.setInt(1,  60);
					pstmt.setInt(2, 90);
					ResultSet rs2 = pstmt.executeQuery();
					count = 0;
					System.out.println("Junior(s)");
					System.out.println("-----------------");
					while(rs2.next()) {
						String firstName = rs2.getString("first_name");
						String lastName = rs2.getString("last_name");
						int creds = rs2.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
						count++;
					}
					
					System.out.println("\nTotal: " + count);					
					rs2.close();
					break;
					
				case "sn":
					pstmt.setInt(1, 90);
					pstmt.setDouble(2, Integer.MAX_VALUE);
					ResultSet rs3 = pstmt.executeQuery();
					count=0;
					System.out.println("Senior(s)");
					System.out.println("-----------------");
					while(rs3.next()) {
						String firstName = rs3.getString("first_name");
						String lastName = rs3.getString("last_name");
						int creds = rs3.getInt("credits");
						System.out.println("Name: " + firstName + " " + lastName +
								"    Creadits: " + creds);
						count++;
					}

					System.out.println("\nTotal: " + count);					
					rs3.close();
					break;
				default:
					System.out.println("That is not a valid option.");
				
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
