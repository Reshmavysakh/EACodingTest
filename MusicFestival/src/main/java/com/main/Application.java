package com.main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
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
//				System.out.println("\nJSON Response in String format");
//				System.out.println(jsonArray);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			JSONArray ob;
			Map<String, String> bandRecord;
			Map<String, String> festivalBand;
			String rootObject;
			JSONArray firstArray;
			JSONObject jb;
			JSONObject jsobj;
			List<String> bands;
			List<String> musicfestivals;
			List<Object> records;
			if (jsonArray.length() > 0) {
				ob = new JSONArray(jsonArray);
				for (int i = 0; i < ob.length(); i++) {
					jsobj = ob.getJSONObject(i);

					rootObject = (String) jsobj.get("name");
					firstArray = (JSONArray) jsobj.get("bands");

					if (rootObject.equals(null) | rootObject == " ") {

					}
					for (int x = 0; x < firstArray.length(); x++) {
						if (firstArray.getJSONObject(x).equals(null)) {
							jb = null;
						} else
							jb = firstArray.getJSONObject(x);

						String bandname = jb.getString("name");
						String record = jb.getString("recordLabel");
						bandRecord = new HashMap<String, String>();
						festivalBand = new HashMap<String, String>();
						bandRecord.put(bandname, record);
						festivalBand.put(rootObject, bandname);

						Map<Object, Object> sortedbandrecord = bandRecord.entrySet().stream()
								.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
										Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
						Map<Object, Object> sortedfestivalband = festivalBand.entrySet().stream()
								.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
										Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

						String recod_label = "";
						records = new ArrayList<Object>();
						bands = new ArrayList<String>();
						musicfestivals = new ArrayList<String>();
						for (Map.Entry<Object, Object> entry : sortedbandrecord.entrySet()) {
							if ((records.size()) > 0 && records.contains(entry.getValue())) {
								// do nothing
							} else {
								records.add(entry.getValue());
								recod_label = entry.getValue().toString();

								System.out.println("RecordLabel    :" + recod_label);
							}

							for (Map.Entry<Object, Object> entry1 : sortedfestivalband.entrySet()) {
								if (entry1.getValue().equals(entry.getKey())) {
									bands.add(entry1.getValue().toString());
									musicfestivals.add(entry1.getKey().toString());
								}
							}
							if (!(bands.isEmpty())) {
								bands.forEach(band -> {
									System.out.println("Band:" + band);
								});
							}
							if (!(musicfestivals.isEmpty())) {
								musicfestivals.forEach(festival -> {
									System.out.println("Music Festivals:" + festival);
								});
							}
						}

					}
				}
			} else {
				System.out.println("No input received");
			}
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
