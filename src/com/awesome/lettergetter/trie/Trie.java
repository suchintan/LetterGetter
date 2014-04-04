package com.awesome.lettergetter.trie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Trie {
	private Node n;
	
	private static Trie trie;
	private Map<String, String[]> map;
	
	public static Trie getInstance(){
		if(trie == null){
			trie = new Trie();
		}
		return trie;
	}
	
	public static boolean exists(){
		return trie != null && trie.getRoot() != null && trie.getRoot().getChildren()[0] != null;
	}
	
	private Trie(){
		n = new Node("");
		map = new HashMap<String, String[]>();
	}
	
	public void addWord(String word, String definition, int frequency){
		n.addWord(word.toLowerCase(), definition, frequency);
		map.put(word, new String[]{definition, String.valueOf(frequency)});
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

	public Map<String, String[]> getWordsMap() {
		return map;
	}

	public void setWordsMap(Map<String, String[]> map) {
		this.map = map;
	}
}
