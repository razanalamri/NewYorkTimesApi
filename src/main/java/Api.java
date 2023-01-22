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

public class Api {
	
	
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
		
	
}
	
	

	
	
}
