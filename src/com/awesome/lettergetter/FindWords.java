package com.awesome.lettergetter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class FindWords {
	private final static String wordsFileName = "words.txt";
	Context context;
	FileFactory factory;
	
	public FindWords(Context context){
		this.context = context;
		factory = new FileFactory(context.getAssets());
	}
	
	private String buildRegex(String query) {
		String s = "";
		for (char c : query.toCharArray()) {
			if(c == '-'){
				s+="[a-z]";
			}else if(c == '*'){
				s+="(.*)";
			}else{
				s+="["+c+"]";
			}
		}
		return s;
	}
	
	public List<Word> query(String query){
		List<Word> words = new ArrayList<Word>();
		
		List<String> allWords = factory.readFromAssets(query);
		
		String regex = buildRegex(query);
		
		for(String s : allWords){
			if(s.matches(regex)){
				words.add(new Word(s, ""));
			}
		}
		
		return words;
	}
}
