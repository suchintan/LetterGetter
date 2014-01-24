package com.awesome.lettergetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.res.AssetManager;

public class FileFactory {
	AssetManager assets;
	
	public FileFactory(AssetManager assets){
		this.assets = assets;
	}
	
	public List<String> readFromAssets(String filename, String regex){
		List<String> list = new ArrayList<String>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(assets.open(filename)));
			String in = br.readLine();
			while(in != null){
				if(in.matches(regex)){					
					list.add(in);
				}
				
				in = br.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return list;
	}
}
