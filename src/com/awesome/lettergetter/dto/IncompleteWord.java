package com.awesome.lettergetter.dto;
import java.util.List;

import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.factory.IncompleteWordFactory;
import com.awesome.lettergetter.factory.PointHelper;


public class IncompleteWord {
	private String word;
	private String definition;
	private int points;
	private int frequency;
	private boolean rare;
	private List<Word> solutions;
	private DIFFICULTY difficulty;
	
	public IncompleteWord(String word, String definition, int frequency) {
		this.setWord(word);
		this.setDefinition(definition);
		this.setFrequency(frequency);
		this.setPoints(PointHelper.generatePoints(word));
		this.setDifficulty(DIFFICULTY.getDifficulty(word.length()));
		this.setRare(frequency < 30);
		updateSolutions();
	}
	
	public boolean addLetter(char c, int position){
		if(getWord().toCharArray()[position] != '-'){
			return false;
		}
		
		int index = getWord().indexOf("-");
		this.setWord(getWord().replaceFirst("-", String.valueOf(c)));
		updateSolutions();
		if(solutions.size() < 1){
			setWord(getWord().substring(0, index) + "-" + getWord().substring(index+1));
			return false;
		}
		
		return true;
	}

	public void updateSolutions() {
		this.solutions = IncompleteWordFactory.getInstance().getSolutions(this.getWord());
	}
	
	public boolean isSolved(){
		updateSolutions();
		return !getWord().contains("-") && solutions.size() == 1 && solutions.get(0).getWord().equals(getWord());
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public boolean isRare() {
		return rare;
	}

	public void setRare(boolean rare) {
		this.rare = rare;
	}

	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DIFFICULTY difficulty) {
		this.difficulty = difficulty;
	}
	
}
