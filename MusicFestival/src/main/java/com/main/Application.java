package com.main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;


public class Application {

	public static void main(String[] args) {
		String jsonArray = "";

		try {

			URL url = new URL("http://eacodingtest.digital.energyaustralia.com.au/api/v1/festivals");
			// Parse URL into HttpURLConnection in order to open the connection in order to
			// get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			// Use the connect method to create the connection bridge
			conn.connect();
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a runtime
			// exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);

			else {
				// Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					jsonArray += sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");
				System.out.println(jsonArray);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			JSONArray ob = new JSONArray(jsonArray);
			Map<String, String> bandRecord=new HashMap<>();
			Map<String, String> festivalBand=new HashMap<>();
			String rootObject ;
			JSONArray firstArray;
			JSONObject jb ;
			JSONObject jsobj;
			
			
			for (int i = 0; i < ob.length(); i++) {
				 jsobj = ob.getJSONObject(i);

				 rootObject = (String) jsobj.get("name");
				 firstArray = (JSONArray) jsobj.get("bands");
				
				if (rootObject.equals(null) | rootObject == " ")
				{
					
				}
				 for (int x = 0; x < firstArray.length(); x++) {
					 if(firstArray.getJSONObject(x).equals(null))
							 {
						 jb=null;
							 }
					 else
			             jb = firstArray.getJSONObject(x);
					 
			            String bandname = jb.getString("name");
			            String record = jb.getString("recordLabel");
			            bandRecord.put(bandname, record);
			            festivalBand.put(bandname,rootObject);
			           
			        }
			}

			 Map<Object, Object> sortedbandrecord = bandRecord.entrySet().stream()
		                .sorted(Map.Entry.comparingByValue())
		                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
			 Map<Object, Object> sortedfestivalband = festivalBand.entrySet().stream()
		                .sorted(Map.Entry.comparingByValue())
		                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

			 
			 for (Map.Entry<Object, Object> entry : sortedbandrecord.entrySet()) {
			        		System.out.println( "RecordLabel    :"+ entry.getValue());
			        for (Map.Entry<Object, Object> entry1 : sortedfestivalband.entrySet()) {
			        	if(entry.getKey().equals(entry1.getKey()))
			        	{
			        		System.out.println("Bands    :"+entry1.getKey());
				        System.out.println("Music Festivals :"+ entry1.getValue());
			        	}
			        	
			    }
			 }
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}

