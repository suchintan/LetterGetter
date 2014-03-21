package com.awesome.lettergetter.trie;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public char c;
	public Node[] children;
	public boolean word;
	
	public Node(char c){
		this.c = c;
		this.children = new Node[26];
		word = false;
	}
	
	public void addWord(String letters){
		if(letters == ""){
			word = true;
		}else{
			char c = letters.toCharArray()[0];
			if(children[c - 'a'] == null){
				Node n = new Node(c);
				children[c - 'a'] = n;				
			}
			children[c = 'a'].addWord(letters.substring(1));
		}
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
}
