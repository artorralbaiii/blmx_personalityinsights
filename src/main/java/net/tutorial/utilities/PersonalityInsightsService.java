package net.tutorial.utilities;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;

public class PersonalityInsightsService {

	private PersonalityInsights service;

	public PersonalityInsightsService() {
		EnvVariables envVar = new EnvVariables();
		Map<String, String> creds = envVar.getCredentials("personality_insights");
		service = new PersonalityInsights("2016-10-19", creds.get("username"), creds.get("password"));
	}

	public String getProfile(String text) {

		String html = "";
		String trait = "";
		String score = "";

		Profile profile = service.getProfile(text).execute();
		JSONParser parser = new JSONParser();
		JSONArray profileArray;
		try {
			JSONObject profileResults = (JSONObject) parser.parse(profile.toString());
			profileArray = (JSONArray) profileResults.get("personality");

			html = "<h1>Big 5 Characteristics</h1>";
			html += "<table>";

			for (Object object : profileArray) {

				JSONObject aJson = (JSONObject) object;

				trait = aJson.get("name").toString();
				score = aJson.get("percentile").toString();

				html += "<tr>";
				html += "<td>" + trait + "</td>";
				html += "<td>" + score + "</td>";
				html += "</tr>";
			}

			html += "</table>";
			html += "<br>";

			profileArray = (JSONArray) profileResults.get("needs");

			html += "<h1>Needs</h1>";
			html += "<table>";

			for (Object object : profileArray) {

				JSONObject aJson = (JSONObject) object;

				trait = aJson.get("name").toString();
				score = aJson.get("percentile").toString();

				html += "<tr>";
				html += "<td>" + trait + "</td>";
				html += "<td>" + score + "</td>";
				html += "</tr>";
			}

			html += "</table>";
			html += "<br>";

			profileArray = (JSONArray) profileResults.get("values");

			html += "<h1>Values</h1>";
			html += "<table>";

			for (Object object : profileArray) {

				JSONObject aJson = (JSONObject) object;

				trait = aJson.get("name").toString();
				score = aJson.get("percentile").toString();

				html += "<tr>";
				html += "<td>" + trait + "</td>";
				html += "<td>" + score + "</td>";
				html += "</tr>";
			}

			html += "</table>";

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return html;
	}

}
