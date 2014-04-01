package com.awesome.lettergetter;

public class Leader {
	private String nickName;
	private int score;
	
	public Leader(String nickName, int score){
		super();
		this.nickName = nickName;
		this.score = score;
	}
	
	public String getNickName() {
		return nickName;
	}

	public int getScore() {
		return score;
	}

}
