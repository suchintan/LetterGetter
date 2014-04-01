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
	
	//Creates shop items in gamestate and 
	//returns a list of letters with cost
	public List<LetterItem> getShopData(){
		List<LetterItem> letters = new ArrayList<LetterItem>();
		letters.add(new LetterItem("A", 2));
		letters.add(new LetterItem("B", 3));
		letters.add(new LetterItem("C", 3));
		letters.add(new LetterItem("D", 2));
		letters.add(new LetterItem("E", 1));
		letters.add(new LetterItem("F", 4));
		letters.add(new LetterItem("G", 2));
		letters.add(new LetterItem("H", 4));
		letters.add(new LetterItem("I", 1));
		letters.add(new LetterItem("J", 8));
		letters.add(new LetterItem("K", 5));
		letters.add(new LetterItem("L", 1));
		letters.add(new LetterItem("M", 3));
		letters.add(new LetterItem("N", 1));
		letters.add(new LetterItem("O", 1));
		letters.add(new LetterItem("P", 3));
		letters.add(new LetterItem("Q", 10));
		letters.add(new LetterItem("R", 1));
		letters.add(new LetterItem("S", 1));
		letters.add(new LetterItem("T", 1));
		letters.add(new LetterItem("U", 1));
		letters.add(new LetterItem("V", 4));
		letters.add(new LetterItem("W", 4));
		letters.add(new LetterItem("X", 8));
		letters.add(new LetterItem("Y", 4));
		letters.add(new LetterItem("Z", 10));
		
		return letters;
	}
}
