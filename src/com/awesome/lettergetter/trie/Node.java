package com.awesome.lettergetter.trie;


import java.util.ArrayList;
import java.util.List;

public class Node {
	private String s;
	private Node[] children;
	private boolean word;
	private String definition;
	private int frequency;
	
	public Node(String s){
		this.s = s;
		this.children = new Node[26];
		this.word = false;
	}
	
	public void addWord(String letters, String definition, int frequency){
		if(letters.equals("")){
			this.word = true;
			this.definition = definition;
			this.frequency = frequency;
		}else{
			char c = letters.toCharArray()[0];
			if(children[c - 'a'] == null){
				Node n = new Node(String.valueOf(c));
				children[c - 'a'] = n;				
			}
			children[c - 'a'].addWord(letters.substring(1), definition, frequency);
		}
	}
	
	public Node getWord(String word){
		if(!word.equals("")){
			char c = word.toCharArray()[0];
			if(this.children[c - 'a'] == null){
				return null;
			}
			return this.children[c - 'a'].getWord(word.substring(1));
		}
		
		if(this.word == false){
			return null;
		}
		
		return this;				
	}
	
	public Node[] getChildren(){
		return children;
	}
	
	public List<Node> getTruncatedChildren(){
		List<Node> list = new ArrayList<Node>();
		for(Node n : children){
			if(n != null){
				list.add(n);
			}
		}
		return list;
	}
	
	public Node getChild(char c){
		return children[c - 'a'];
	}

	public boolean isWord() {
		return word;
	}

	public String getDefinition() {
		if(this.isWord()){			
			return definition;
		}else{
			return null;
		}
	}

	public int getFrequency() {
		if(this.isWord()){
			return frequency;
		}else{
			return -1;
		}
	}
	
	public void populateFromString(String in){
		
	}

	public String toString(){
		String str = "{";
		str += "char:" + getS() + ",word:" + word + ",definition:" + definition + ",frequency:" + frequency;
		str+=",children:{\n";
		for (Node n : children) {
			if(n == null){
				str+="{null},";
			}else{
				str+=n.toString();
			}
		}
		str +="\n}";
		str += "}";
		return str;
	}

	public String getS() {
		return s;
	}
}
