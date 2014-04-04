package com.awesome.lettergetter.trie;
import java.util.ArrayList;
import java.util.List;



public class Trie {
	private Node n;
	
	public Trie(){
		n = new Node("");
	}
	
	public void addWord(String word, String definition, int frequency){
		n.addWord(word.toLowerCase(), definition, frequency);
	}
	
	public Node getRoot(){
		return n;
	}
	
	public boolean containsWord(String word){
		return n.getWord(word) != null;
	}
	
	public String getDefinition(String word){
		Node tmp = n.getWord(word);
		
		if(tmp == null){
			return null;
		}else{
			return tmp.getDefinition();
		}
	}
	
	public List<String> query(String query){
		List<String> result = new ArrayList<String>();
		query = query.toLowerCase();
		
		if(query.equals("")) {
			return result;
		}
					
		if(query.contains("-")){
			for(int c = 'a'; c < 'z'+1; c++){
				result.addAll(query(query.replaceFirst("-", String.valueOf((char)c))));
			}
		}else{
			if(this.containsWord(query)){
				result.add(query);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return n.toString();
	}
}
