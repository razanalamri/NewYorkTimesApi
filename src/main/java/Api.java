import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.google.gson.Gson;

public class Api {
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=NYT;encrypt=true;trustServerCertificate=true";
	public static String user = "sa";
	public static String pass = "root";
	public static Connection con = null;

	static Scanner scanner1=new Scanner(System.in);
	response response;
	public response getResponse() {
		return response;
	}

	public void setResponse(response response) {
		this.response = response;
	}


	results results;
	
	public results getResults() {
		return results;
	}

	public void setResults(results results) {
		this.results = results;
	}


	 public static void main(String[] args) throws IOException, InterruptedException {
		
		 inserting.insertTable1();
		 
		 
		 System.out.println("Please choose one Option :");
		 System.out.println("1-Which section had the most articles published on a particular day?");
		 System.out.println("2-How many articles were published each month in the year 2021?");
		 System.out.println("3-What are the top 10 articles with the most views?");
		 System.out.println("4-How many articles were written by each author?");
		 System.out.println("5-What are the top 5 sections with the most articles?");
		 
		 int option=scanner1.nextInt();
		 
		 
		 
		 switch(option){
		 
		 case 1:
			 
			 break;
			 
			 
		 case 2:
			 
			 
			 break;
			 
			 
		 case 3:
			 
			 break;
			 
			 
		 case 4:

				
					 String sql ="SELECT author, COUNT(*) AS title FROM authors1 GROUP BY author";
			 System.out.println(sql);
					
			         try {

			             Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			             // Registering drivers
			             DriverManager.registerDriver(driver);

			             // Reference to connection interface
			             con = DriverManager.getConnection(url, user,
			                     pass);

			             // Creating a statement
			             Statement st = con.createStatement();
			             int m = st.executeUpdate(sql);
			             
			             con.close();
			         }
			         catch (Exception ex) {

			             System.err.println(ex);
			    	 
			     }


			
		 
			 
			  
			 
			 
			 break;
			 
			 
		 case 5 :
			 
			 
			 
			 
		 }
}}
	 
	 
	
	

	
	

