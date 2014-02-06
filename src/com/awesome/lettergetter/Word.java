package com.awesome.lettergetter;

public class Word {
	private String word;
	private String definition;
	
	public Word(String word, String definition){
		this.setWord(word);
		this.setDefinition(definition);
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
	
	
}
