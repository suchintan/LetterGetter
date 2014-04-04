package com.awesome.lettergetter;

import com.awesome.lettergetter.enums.LETTER;

public class PointHelper {
	public static int generatePoints(String word){
		if(word == null){
			return 0;
		}
		
		int points = 0;
		
		for (char s : word.toUpperCase().toCharArray()) {
			if(s-'A' >= 0 && s-'Z' <= 0){
				//Letters[65-65] = Letters[0] = A. Works for all letters.
				//The letter A has an ascii value of 65. Letters[0] = A, so if we do
				points += LETTER.values()[s-'A'].getScore(); 
			}
		} 
		
		return points;
	}
	
	
}
