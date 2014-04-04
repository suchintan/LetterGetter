package com.awesome.lettergetter.factory;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.awesome.lettergetter.dto.User;
import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.enums.LETTER;

public class GameState {
	private User user;
	
	static Boolean hasCompletedWord = false;
	static Boolean hasStartedWord = false;
	static int buttonRef;
	static String ans = "a"; 
	
	private static GameState state;
	private Context context;
	
	public static GameState getInstance(Context context){
		String username = UserFactory.getInstance().getActiveUser().getName();
		if(state == null || !state.getUser().getName().equals(username)){
			saveCurrentGameState();
			state = new GameState(username, context);
		}
		return state;
	}
	
	private static void saveCurrentGameState() {
		// TODO Auto-generated method stub
		
	}

	private GameState(String username, Context context){
		this.user = new User(username);
		this.context = context;
	}
	
	//Gets the current word needed to be completed
	public String getCurrentWord(){
		return "system design";		
	}
	
	//Gets the new word to be completed
	public String getNextWord(DIFFICULTY d){
		return "design";		
	}
	
	//Checks if the user has completed the word
	public void setHasCompletedWord(Boolean bool){
		
		this.hasCompletedWord = bool;
		
	}
		
	public static  Boolean getHasCompletedWord(){
		
		
		return hasCompletedWord;
	}
	
	
	public static void setHasStartedWord(Boolean bool){
		
		hasStartedWord = bool;
		
	}
		
	public static  Boolean getHasStartedWord(){
		
		
		return hasStartedWord;
	}
	
	public int getLetterQuantityFromTray(LETTER l){
		return this.getUser().getTray().getTrayMap().get(l);
	}
	
	//Get Leaderboard Data 
	//Sort by high score then return
	public List<User> getLeaderboardData(){
		List<User> leaders = new ArrayList<User>();
		leaders.add(new User("Hazik", 9001));
		leaders.add(new User("Sho", 1000));
		leaders.add(new User("Tom", 500));
		leaders.add(new User("Suchintan", 2));
				
		return leaders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public static void setWordRef(int i){
	
		buttonRef = i;
			
	}
	

	public int getWordRef(){
		
		return buttonRef;
	}
	
	
	public static void setWordAns(String a){
		
	    ans = a;
			
	}
	
	public String getWordAns(){
		
		return ans;
	}
	
//	public void ansWord(int i, char a){
//		
//		
//		
//		
//	}
}

