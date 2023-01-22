import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import com.google.gson.Gson;

public class inserting {
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=NYT;encrypt=true;trustServerCertificate=true";
	public static String user = "sa";
	public static String pass = "root";
	public static Connection con = null;

	 public static void insertTable1() throws IOException, InterruptedException {
			
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=cd24tb6MoLFcGV69vGkm8b9AQ0VosqAX")).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String jsonString0 = response.body();
			Gson gson = new Gson();
			Api data1 = gson.fromJson(jsonString0, Api.class);
			
			for (Integer i=0;i<1;i++) {
				String pub_data=data1.getResponse().getDocs()[i].getPub_date();
				String document_type=data1.getResponse().getDocs()[i].getDocument_type();
				int word_count =data1.getResponse().getDocs()[i].getWord_count();
				String uri=data1.getResponse().getDocs()[i].getUri();
				
		
				
				
				
				 String sql = "insert into articels1 values('"+pub_data+"', '"+document_type+"','"+word_count+"', '"+uri+"')";
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


		}}
	 
	 
	 public static void insertTable2() throws IOException, InterruptedException {
			
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=cd24tb6MoLFcGV69vGkm8b9AQ0VosqAX")).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String jsonString0 = response.body();
			Gson gson = new Gson();
			Api data1 = gson.fromJson(jsonString0, Api.class);
			
			for (Integer i=0;i<jsonString0.length();i++) {
				String desctiption=data1.getResults().getBooks()[i].getDescription();
				String title=data1.getResults().getBooks()[i].getTitle();
				String authors =data1.getResults().getBooks()[i].getAuthor();
				String price=data1.getResults().getBooks()[i].getPrice();
				
		
				
				
				
				 String sql = "insert into authors1 values('"+desctiption+"', '"+title+"','"+authors+"', '"+price+"')";
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


		}}
	 
	 public static void insertTable3() throws IOException, InterruptedException {
			
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=cd24tb6MoLFcGV69vGkm8b9AQ0VosqAX")).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String jsonString0 = response.body();
			Gson gson = new Gson();
			Api data1 = gson.fromJson(jsonString0, Api.class);
			
			for (Integer i=0;i<jsonString0.length();i++) {
				String section_name=data1.getResponse().getDocs()[i].getSection_name();
				String subsection_name=data1.getResponse().getDocs()[i].getSubsection_name();
			
				
		
				
				
				
				 String sql = "insert into sections1 values('"+section_name+"', '"+subsection_name+"')";
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


		}}
	 
	 
	 
	
}
