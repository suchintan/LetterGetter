package com.awesome.lettergetter;

import java.util.ArrayList;
import java.util.List;



import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.Letters;

public class GameState {
	User user;
	
	//Gets the current word needed to be completed
	public String getCurrentWord(){
		return "system design";		
	}
	
	//Gets the new word to be completed
	public String getNextWord(DIFFICULTY d){
		return "design";		
	}
	
	//Checks if the user has completed the word
	public Boolean hasCompletedWord(){
		return true;
	}
	
	//Get Leaderboard Data 
	//Sort by high score then return
	public List<Leader> getLeaderboardData(){
		List<Leader> leaders = new ArrayList<Leader>();
		leaders.add(new Leader("Hazik", 9001));
		leaders.add(new Leader("Sho", 1000));
		leaders.add(new Leader("Tom", 500));
		leaders.add(new Leader("Suchintan", 2));
				
		return leaders;
	}
	
	//LetterNum keeps track off the letters available to the user
	public enum LetterNum{
		
		A(9),B(2),C(2),D(4),E(12),F(2),G(3),H(2),I(9),J(1),K(1),L(4),M(2),N(6),O(8),P(2),Q(1),R(6),S(4),T(6),U(4),V(2),W(2),X(1),Y(2),Z(1);	
		
		private int quantity;
		
		LetterNum(int quantity){
			this.quantity = quantity;
		}
		
		public int getQuantity(){
			return quantity;
		}
		
		public void setQuantity(int quantity){
			this.quantity = quantity;
		}
		
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

