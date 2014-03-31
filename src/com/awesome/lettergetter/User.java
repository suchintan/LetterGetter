package com.awesome.lettergetter;

import com.awesome.lettergetter.enums.DIFFICULTY;

public class User {
	private String name;
	private int points;
	private int score;
	Tray tray;
	IncompleteWord incompleteWord;
	private int rank;	
	
	public User(String username){
		this(username, 0, 0, new Tray(), null, Integer.MAX_VALUE);
	}
	
	public User(String username, int points, int score, Tray tray, IncompleteWord word, int rank){
		this.setName(username);
		this.setPoints(points);
		this.tray = tray;
		this.incompleteWord = word;
		this.setRank(rank);
	}
	
	
	public Word generateWord(DIFFICULTY d){
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
}
