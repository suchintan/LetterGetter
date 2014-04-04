package com.awesome.lettergetter.dto;

import com.awesome.lettergetter.PointHelper;

public class Word {
	private String word;
	private String definition;
	private int frequency;
	
	public Word(String word, String definition, int frequency){
		this.setWord(word);
		this.setDefinition(definition);
		this.setFrequency(frequency);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public int getPoints(){
		return PointHelper.generatePoints(this.getWord());
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
