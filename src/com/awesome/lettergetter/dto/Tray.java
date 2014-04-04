package com.awesome.lettergetter.dto;

import java.util.HashMap;
import java.util.Map;

import com.awesome.lettergetter.enums.LETTER;

public class Tray {
	Map<LETTER, Integer> tray;
	
	public Tray(){
		tray = new HashMap<LETTER, Integer>();
		for(LETTER l : LETTER.values()){
			tray.put(l, 1);
		}
	}
	
	public void addLetter(LETTER l){
		tray.put(l, tray.get(l)+1);
	}
	
	public boolean removeLetter(LETTER l){
		if(!isDeletePossible(l)){
			return false;
		}
		
		tray.put(l, tray.get(l)-1);
		return true;
	}
	
	public boolean isDeletePossible(LETTER l){
		if(tray.get(l) <= 0){
			return false;
		}
		return true;
	}
	
	public Map<LETTER, Integer> getTrayMap(){
		return tray;
	}
	
	
}
