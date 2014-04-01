package com.awesome.lettergetter;

public class LetterItem {
	private String letter;
	private int cost;
	
	public LetterItem(String letter, int cost)
	{
		super();
		this.letter = letter;
		this.cost = cost;
	}
	
	public String getLetter(){
		return letter;
	}
	
	public int getCost(){
		return cost;
	}	
	
}
