package com.qainfotech.automation.snpAPITest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Reporter;

import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.response.Response;

public class JoinPlayer{
	
	/*2. Join Player*/
	public ArrayList<Object> JoinPlayer(String BoardID, String Name)
	{
		ArrayList<Object> data = new ArrayList();
		  String contentTypeJSON = "application/json";
		  String call = "{\"board\": "+BoardID+", \"player\":{\"name\": \""+Name+"\"}}";
		  System.out.println(call);
		  Response JoinPlayer = given().contentType(contentTypeJSON).body(call).when().post("http://10.0.1.86/snl/rest/v1/player.json");
		  Response boardDetails = get("http://10.0.1.86/snl/rest/v1/board/"+BoardID+".json");
		  ArrayList <String> playerName = boardDetails.jsonPath().getJsonObject("response.board.players.name");
		  Reporter.log("PlayerNames: " + playerName, true);
		  ArrayList<String>  playerID = boardDetails.jsonPath().getJsonObject("response.board.players.id");
		  Reporter.log("PlayerIDs: " + playerID, true);
		  data.add(playerName.get(playerName.size()-1));
		  data.add(playerID.get(playerID.size()-1));
		  
//		  JSON
		  
		return data;
	}

}
