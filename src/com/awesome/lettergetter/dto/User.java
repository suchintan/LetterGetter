package com.awesome.lettergetter.dto;

import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.factory.IncompleteWordFactory;

public class User implements Comparable<User>{
	private String name;
	private int points;
	private int score;
	private Tray tray;
	private IncompleteWord incompleteWord;
	private int rank;	
	
	public User(String username){
		this(username, 0, 0, new Tray(), Integer.MAX_VALUE);
	}
	
	public User(String username, int score){
		this(username, 0, score, new Tray(), Integer.MAX_VALUE);
	}
	
	public User(String username, int points, int score, Tray tray, int rank){
		this.setName(username);
		this.setPoints(points);
		this.setTray(tray);
		this.setRank(rank);
	}
	
	
	public void generateWord(DIFFICULTY d){
		this.incompleteWord = IncompleteWordFactory.getInstance().generateRandomIncompleteWord(d);
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

	@Override
	public int compareTo(User another) {
		if(this.score < another.score){
			return 1;
		}
		if(this.score > another.score){
			return -1;
		}
		return 0;
	}

	public Tray getTray() {
		return tray;
	}

	public void setTray(Tray tray) {
		this.tray = tray;
	}

	public IncompleteWord getIncompleteWord() {
		return incompleteWord;
	}

	public void setIncompleteWord(IncompleteWord incompleteWord) {
		this.incompleteWord = incompleteWord;
	}
}
