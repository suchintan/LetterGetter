package com.awesome.lettergetter.enums;

public enum DIFFICULTY {
	EASY, MEDIUM, HARD;
	
	public static DIFFICULTY getDifficulty(int wordlength){
		if(wordlength < 5){
			return DIFFICULTY.EASY;
		}
		if(wordlength < 9){
			return DIFFICULTY.MEDIUM;
		}
		return DIFFICULTY.HARD;
	}
}
