import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;


//Retrieve weather data from API - this backend logic will fetch the latest weather
//data from the external API and return it. 
// The GUI will display the data to the user
public class WeatherAppBckEnd {
	public static JSONObject getWeatherData(String locationName)
	{
		//get location coordinates using the geolocation API
		JSONArray locationData = getLocationData(locationName);
		
		return null;
	}
	
	//Retrieves geographic coordinates for given location name
	public static JSONArray getLocationData(String locationName) {
		// TODO Auto-generated method stub
		//Replacing any whitespace in locationName with + to adhere to API's request format
		locationName = locationName.replaceAll(" ", "+");
		
		//Build API url with location parameter
		String urlString = "https://geocoding-api.open-meteo.com/v1/search?name="
				+ locationName + "&count=10&language=en&format=json";
		
		try
		{
			// call api and get a response
			HttpURLConnection conn = fetchApiResponse(urlString);
			
			//Check Response Status
			//200 means Good
			if(conn.getResponseCode() != 200)
			{
				System.out.println("Error: Could not connect to API");
				return null;
			}
			else
			{
				//Store the API Result
				StringBuilder resultJson = new StringBuilder();
				Scanner scanner = new Scanner(conn.getInputStream());
				//Read and store the resulting Json data into our string builder
				while(scanner.hasNext())
				{
					resultJson.append(scanner.nextLine());
				}
				
				//Close scanner
				scanner.close();
				
				//close Url connection
				conn.disconnect();
				
				//Parse the JSON string into JSON obj
				JSONParser parser = new JSONParser();
				JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));
				
				//get the list of location data the API generated from the location name
				JSONArray locationData = (JSONArray) resultJsonObj.get("results");
				return locationData;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Couldnt find the location
		return null;
		
	}

	private static HttpURLConnection fetchApiResponse(String urlString) {
		// TODO Auto-generated method stub
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// set request method to get
			conn.setRequestMethod("GET");
			
			conn.connect();
			return conn;
		}catch(IOException e){
			e.printStackTrace();
		}
		//could not make connection
		return null;
	}
}
