package com.qainfotech.automation.snpAPITest;

import static io.restassured.RestAssured.get;

import java.util.ArrayList;

import org.testng.Reporter;

import io.restassured.response.Response;

public class RollDiceAndMovePlayer {

	public String RollDiceAndMove(String newboardID, String PlayerID) {

		Response Roll_MovePlayer = get("http://10.0.1.86/snl/rest/v1/move/" + newboardID + ".json?player_id="+PlayerID);
		Reporter.log("Roll Dice and Moved Player", true);
		Response boardDetails = get("http://10.0.1.86/snl/rest/v1/board/" + newboardID + ".json");
		Reporter.log("Getting Board Details", true);
		String Player_Postion = getPlayerPosition(newboardID, PlayerID);
		Reporter.log("Player Postion: " + Player_Postion, true);
		return Player_Postion;

	}

	public String getPlayerPosition(String boardID , String playerID) {
		Response res = get("http://10.0.1.86/snl/rest/v1/board/"+boardID+".json").then().extract().response();
		String position="";
		ArrayList <String> playerIDs = res.jsonPath().getJsonObject("response.board.players.id");
		  Reporter.log("PlayerIDs: " + playerIDs, true);
		  ArrayList<String>  playerPosition = res.jsonPath().getJsonObject("response.board.players.position");
		  Reporter.log("PlayerPositions: " + playerPosition, true);
		  int i=0;
		  for(Object id : playerIDs) {
			  if(id.toString().equals(playerID)) {
				  System.out.println("##### "+id.toString());
				  System.out.println("@@@@@ " +playerID);
				  position= String.valueOf(playerPosition.get(i));
				  
			  break;
			  }
			  i++;
		  }
		return position;
	}

}
