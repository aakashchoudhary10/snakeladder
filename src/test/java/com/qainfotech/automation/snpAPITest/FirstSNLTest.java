package com.qainfotech.automation.snpAPITest;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class FirstSNLTest {
	CreateNewBoard newBoard = new CreateNewBoard(); 
	JoinPlayer Join = new JoinPlayer();
	RollDiceAndMovePlayer mvplayer = new RollDiceAndMovePlayer();
	static String BoardID;
	
  @BeforeClass
  public void CreateBoard()
  {
	  BoardID = newBoard.userCreateNewBoard();
  }
  
  @AfterMethod
  public void afterTest() {
	  System.out.println("########################################################################");
  }

	@Test(priority = 1)
	public void firstTest() {
		ArrayList<Object> player1details = Join.JoinPlayer(BoardID, "Aakash");
		ArrayList<Object> player2details = Join.JoinPlayer(BoardID, "Love");
		String playerName1 = (String) player1details.get(0);
		String playerID1 = (String) player1details.get(1).toString();
		System.out.println(playerID1);
		Reporter.log("Player 1 details" + player1details, true);
		String playerName2 = (String) player2details.get(0);
		String playerID2 = (String) player2details.get(1).toString();
		System.out.println(playerID2);
		Reporter.log("Player 2 details" + player2details, true);
		mvplayer.RollDiceAndMove(BoardID, playerID1);
		mvplayer.RollDiceAndMove(BoardID, playerID2);

	}

//  @Test(priority=3)
//  public void secondTest() {
////		 ArrayList <Object> player2details = Join.JoinPlayer(BoardID, "Love"); 
//		 String playerName2 = (String) player2details.get(0); 
//		 String playerID2 = (String)player2details.get(1).toString(); 
//		 System.out.println(playerID2);
//		 Reporter.log("Player 2 details"+player2details , true);
//		 mvplayer.RollDiceAndMove(BoardID, playerID2);
//  }
}
