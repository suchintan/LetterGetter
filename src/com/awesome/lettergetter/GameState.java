package com.awesome.lettergetter;

import java.util.ArrayList;
import java.util.List;

import com.awesome.lettergetter.enums.DIFFICULTY;

public class GameState {
	User user;
	
	//Gets the current word needed to be completed
	public String getCurrentWord(){
		return "system design";		
	}
	
	//Gets the new word to be completed
	public String getNextWord(DIFFICULTY d){
		return "system design";		
	}
	
	//Checks if the user has completed the word
	public Boolean hasCompletedWord(){
		return true;
	}
	
	//Get Leaderboard Data 
	//Sort by high score then return
	public List<Leader> getLeaderboardData(){
		List<Leader> leaders = new ArrayList<Leader>();
		leaders.add(new Leader("Sho", 1000));
		leaders.add(new Leader("Tom", 500));
		leaders.add(new Leader("Suchintan", 2));
		leaders.add(new Leader("Hazik", 0));
		
		return leaders;
	}
}
