package com.qainfotech.automation.snpAPITest;

import static io.restassured.RestAssured.get;

import org.testng.Reporter;

import io.restassured.response.Response;

public class CreateNewBoard {
	
	/*Create New Board*/
	public String userCreateNewBoard() {
		  Response newBoardResponse = get("http://10.0.1.86/snl/rest/v1/board/new.json");
		  String newboardID = newBoardResponse.body().jsonPath().getString("response.board.id");
		  Reporter.log("Board-ID: " + newboardID, true);
		return newboardID;
		
	}
	
	

}
