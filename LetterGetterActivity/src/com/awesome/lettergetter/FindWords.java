package com.awesome.lettergetter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class FindWords {
	private final static String wordsFileName = "truncated_words.txt";
	Context context;
	FileFactory factory;
	
	public FindWords(Context context){
		this(context, new FileFactory(context.getAssets()));
	}
	
	public FindWords(Context context, FileFactory factory){
		this.context = context;
		this.factory = factory;
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
		
		String regex = buildRegex(query);
		List<String[]> allWords = factory.readFromAssets(wordsFileName, regex);
		
		
		for(String[] s : allWords){
			words.add(new Word(s[0], "", Integer.parseInt(s[1])));
		}
		
		return words;
	}
}
