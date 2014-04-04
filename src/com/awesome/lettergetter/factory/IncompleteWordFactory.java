package com.awesome.lettergetter.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.awesome.lettergetter.dto.IncompleteWord;
import com.awesome.lettergetter.dto.Word;
import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.trie.Trie;

public class IncompleteWordFactory {
	private static IncompleteWordFactory singleton;
	
	public static IncompleteWordFactory getInstance(){
		if(singleton == null){
			singleton = new IncompleteWordFactory();
		}
		return singleton;
	}
	
	public IncompleteWordFactory() {
		
	}

	public List<Word> getSolutions(String word) {
		return convertToWord(Trie.getInstance().query(word));
	}
	
	private List<Word> convertToWord(List<String> query) {
		List<Word> words = new ArrayList<Word>();
		
		for (String string : query) {
			String[] dandf = Trie.getInstance().getWordsMap().get(string);
			words.add(new Word(string, dandf[0], Integer.parseInt(dandf[1])));
		}
		
		return words;
	}
	
	public IncompleteWord generateRandomIncompleteWord(DIFFICULTY difficulty){
		List<String> words = new ArrayList<String>();
		Map<String, String[]> map = Trie.getInstance().getWordsMap();
		words.addAll(map.keySet());
		
		String word;
		do{
			word = words.get((int)(Math.random() * words.size()));
			
		}while(DIFFICULTY.getDifficulty(word.length()) != difficulty);
		
		int numberOfBlanks = word.length() / 2;
		for(int c = 0; c < numberOfBlanks; c++){
			word = word.substring(c*2) + "-" + word.substring(c*2+1);
		}
		
		return new IncompleteWord(word, map.get(word)[0], Integer.parseInt(map.get(word)[1]));
	}
	
	
}
