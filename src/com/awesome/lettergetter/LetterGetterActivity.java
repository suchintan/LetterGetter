package com.awesome.lettergetter;

import java.util.ArrayList;

import com.awesome.lettergetter.dto.Item;
import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.enums.LETTER;
import com.awesome.lettergetter.factory.GameState;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.AdapterView.OnItemClickListener;

import com.awesome.lettergetter.enums.DIFFICULTY;
import com.awesome.lettergetter.factory.FileFactory;
import com.awesome.lettergetter.factory.GameState;
import com.awesome.lettergetter.trie.Trie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class LetterGetterActivity extends MenuActivity {
	private Button easyBtn, mediumBtn, hardBtn;
	
	int btnId; 
		
	GameState state = GameState.getInstance(this);
	
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;
	GridView gridView;
	
	private Trie trie;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_letter_getter);
        
        
        
        
        /////////////////////////////////////////
        
        
        
        Bitmap aIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.a);
		Bitmap bIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.b);
		Bitmap cIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.c);
		Bitmap dIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.d);
		Bitmap eIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.e);
		Bitmap fIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.f);
		Bitmap gIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.g);
		Bitmap hIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.h);
		Bitmap iIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.i);
		Bitmap jIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.j);
		Bitmap kIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.k);
		Bitmap lIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.l);
		Bitmap mIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.m);
		Bitmap nIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.n);
		Bitmap oIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.o);
		Bitmap pIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.p);
		Bitmap qIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.q);
		Bitmap rIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.r);
		Bitmap sIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.s);
		Bitmap tIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.t);
		Bitmap uIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.u);
		Bitmap vIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.v);
		Bitmap wIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.w);
		Bitmap xIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.x);
		Bitmap yIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.y);
		Bitmap zIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.z);

		
		gridArray.add(new Item(aIcon, state.getLetterQuantityFromTray(LETTER.A), LETTER.A.getScore()));
		gridArray.add(new Item(bIcon, state.getLetterQuantityFromTray(LETTER.B), LETTER.B.getScore()));
		gridArray.add(new Item(cIcon, state.getLetterQuantityFromTray(LETTER.C), LETTER.C.getScore()));
		gridArray.add(new Item(dIcon, state.getLetterQuantityFromTray(LETTER.D), LETTER.D.getScore()));
		gridArray.add(new Item(eIcon, state.getLetterQuantityFromTray(LETTER.E), LETTER.E.getScore()));
		gridArray.add(new Item(fIcon, state.getLetterQuantityFromTray(LETTER.F), LETTER.F.getScore()));
		gridArray.add(new Item(gIcon, state.getLetterQuantityFromTray(LETTER.G), LETTER.G.getScore()));
		gridArray.add(new Item(hIcon, state.getLetterQuantityFromTray(LETTER.H), LETTER.H.getScore()));
		gridArray.add(new Item(iIcon, state.getLetterQuantityFromTray(LETTER.I), LETTER.I.getScore()));
		gridArray.add(new Item(jIcon, state.getLetterQuantityFromTray(LETTER.J), LETTER.J.getScore()));
		gridArray.add(new Item(kIcon, state.getLetterQuantityFromTray(LETTER.K), LETTER.K.getScore()));
		gridArray.add(new Item(lIcon, state.getLetterQuantityFromTray(LETTER.L), LETTER.L.getScore()));
		gridArray.add(new Item(mIcon, state.getLetterQuantityFromTray(LETTER.M), LETTER.M.getScore()));
		gridArray.add(new Item(nIcon, state.getLetterQuantityFromTray(LETTER.N), LETTER.N.getScore()));
		gridArray.add(new Item(oIcon, state.getLetterQuantityFromTray(LETTER.O), LETTER.O.getScore()));
		gridArray.add(new Item(pIcon, state.getLetterQuantityFromTray(LETTER.P), LETTER.P.getScore()));
		gridArray.add(new Item(qIcon, state.getLetterQuantityFromTray(LETTER.Q), LETTER.Q.getScore()));
		gridArray.add(new Item(rIcon, state.getLetterQuantityFromTray(LETTER.R), LETTER.R.getScore()));
		gridArray.add(new Item(sIcon, state.getLetterQuantityFromTray(LETTER.S), LETTER.S.getScore()));
		gridArray.add(new Item(tIcon, state.getLetterQuantityFromTray(LETTER.T), LETTER.T.getScore()));
		gridArray.add(new Item(uIcon, state.getLetterQuantityFromTray(LETTER.U), LETTER.U.getScore()));
		gridArray.add(new Item(vIcon, state.getLetterQuantityFromTray(LETTER.V), LETTER.V.getScore()));
		gridArray.add(new Item(wIcon, state.getLetterQuantityFromTray(LETTER.W), LETTER.W.getScore()));
		gridArray.add(new Item(xIcon, state.getLetterQuantityFromTray(LETTER.X), LETTER.X.getScore()));
		gridArray.add(new Item(yIcon, state.getLetterQuantityFromTray(LETTER.Y), LETTER.Y.getScore()));
		gridArray.add(new Item(zIcon, state.getLetterQuantityFromTray(LETTER.Z), LETTER.Z.getScore()));

	
		

		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
	/////////////////////////////////////////////////////////
		
          
        if (!Trie.exists()){
        	trie = Trie.getInstance();
    		try {
    			List<String[]> words = new FileFactory(getAssets()).readFromAssets("truncated_words.txt", " ");
    			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("dictionary.json")));
    			String json = br.readLine();
    			new Gson().fromJson(json, new TypeReference<HashMap<String, String>>(){}.getType());
				Map<String, String> definitions = new ObjectMapper().readValue(getAssets().open("dictionary.json"), new TypeReference<HashMap<String, String>>(){});
				
				for (int c = 0; c < words.size(); c++) {
					String[] word = words.get(c);
					if(definitions.containsKey(word[0].toUpperCase())){
						trie.addWord(word[0].toLowerCase(), definitions.get(word[0]), Integer.parseInt(word[1]));
					}
				}
			} catch (Exception e){
				
			}

        }
        if ((GameState.getHasStartedWord() == false) && (GameState.getHasCompletedWord()== false)){   
       	 
        	GameState.setHasStartedWord(true);
        	getNextWord();
       	 }
       else if((GameState.getHasStartedWord() == true) && (GameState.getHasCompletedWord() == false)){
       	 
    	   setContentView(R.layout.activity_letter_getter);
    	   setDifficultyBtnsVisible(false);
    	   populateLetters(1, gameState.getCurrentWord().length());
    	
       	 
       		}    
        
        
        
    
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				
				
				RelativeLayout trayLayout = (RelativeLayout) findViewById(R.id.trayView1);
				
				//state.setWordAns("a");
				
				//Intent intent = new Intent(TrayActivity.this, LetterGetterActivity.class);
//				intent.putExtra("Ans", "A");
//				intent.putExtra("id", button_id);
				//startActivity(intent);
				
							
				GameState.setWordAns("a");
				//TableLayout mtable = (TableLayout) findViewById(R.id.tableForButtons);
				Button mButton = (Button) findViewById(getBtnId());
				//mButton.setId(gameState.getWordRef());
				//mButton.setId(2);
				
		
		    	
				int i = position + 65;
				mButton.setText(Character.toString((char)i));
				
		   
				trayLayout.setVisibility(View.GONE);
			
		}
	});

 }
	
//// why doesn't it go to onresume	
	@Override
    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          
	}
	
    //Event handler for Easy Button
	View.OnClickListener easyBtnHandler = new View.OnClickListener() {
		public void onClick(View v) {
			setDifficultyBtnsVisible(false);
			populateLetters(1, gameState.getNextWord(DIFFICULTY.EASY).length());
		
		}
	};
	//Event handler for Medium Button
	View.OnClickListener mediumBtnHandler = new View.OnClickListener() {
		public void onClick(View v) {
			setDifficultyBtnsVisible(false);
			populateLetters(1, gameState.getNextWord(DIFFICULTY.MEDIUM).length());
			 
		}
	};
	//Event handler for Hard Button
	View.OnClickListener hardBtnHandler = new View.OnClickListener() {
		public void onClick(View v) {
			setDifficultyBtnsVisible(false);
			populateLetters(1, gameState.getNextWord(DIFFICULTY.HARD).length());
			 
		}
	};
    
    public void getNextWord(){
        
      	
    	//Assign Button hooks and handlers
        easyBtn = (Button) findViewById(R.id.easy_btn);
        mediumBtn = (Button) findViewById(R.id.medium_btn);
        hardBtn = (Button) findViewById(R.id.hard_btn);
        
        easyBtn.setOnClickListener(easyBtnHandler);
        mediumBtn.setOnClickListener(mediumBtnHandler);
        hardBtn.setOnClickListener(hardBtnHandler);        
    }
    
    private void populateLetters(int numRows, int numCols) {
    	TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
		
    	
    	
    	for (int row = 0; row < numRows; row++) {
			TableRow tableRow = new TableRow(this);
			table.addView(tableRow);
			
			for (int col = 0; col < numCols; col++){
				Button button = new Button(this);
				//Make Button stretch to fit table
				button.setLayoutParams(new TableRow.LayoutParams(
						TableRow.LayoutParams.MATCH_PARENT,
						TableRow.LayoutParams.MATCH_PARENT,
						1.0f));
				//Set the id of each button
				button.setId(col);
				//
				
				button.setTag(col);
				//Set the padding
				button.setPadding(0, 0, 0, 0);
				
				//Gets the letters of the word and prints in button text property
				button.setText(Character.toString(gameState.getCurrentWord().charAt(col)));
				
				//Set the minimum width of the button
				button.setMinimumWidth(0);
				
				//Adds the button to the table
				tableRow.addView(button);
				
			
				
				button.setOnClickListener(getOnClick(button));
				
			}
			
		}
		//Make difficulty buttons invisible
		//setDifficultyBtnsInvisible();
    	
//    	Button btn = (Button) findViewById(btID);
//    	btn.setText("A");
	}
    
    private void setDifficultyBtnsVisible(Boolean bool){
  		//Make difficulty buttons invisible
  		LinearLayout difficultyBtns = (LinearLayout) findViewById(R.id.difficulty);
  		
  		if (bool == true){
  		
  		difficultyBtns.setVisibility(View.VISIBLE);
        }
  		else{
   	    difficultyBtns.setVisibility(View.INVISIBLE);	
  		}
  		
  	}
    
    View.OnClickListener getOnClick(final Button button){
    	return new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				GameState.setWordRef(button.getId());
				int btID =  button.getId() ;//getApplicationContext().getResources().getIdentifier("button" + 3,  "id", getPackageName());
				setBtnId (btID);
				
				dispTray(true);
				
				//startActivity(new Intent(LetterGetterActivity.this, TrayActivity.class));
				
				//Intent i = new Intent(LetterGetterActivity.this, TrayActivity.class);
//				i.putExtra("id",  button.getId());
								
			
		
			}
    		    		
    		
    	};
    	
    	
    };
    
    
    private void dispTray(Boolean bool){
    	
    	
RelativeLayout trayLayout = (RelativeLayout) findViewById(R.id.trayView1);
				
if (bool == true){
		
	trayLayout.setVisibility(View.VISIBLE);
    }
else{
	trayLayout.setVisibility(View.GONE);	
		}
    	
    		
    }
    
  protected void setBtnId(int i){
	  
	  this.btnId = i;
	  
	  
  }
  
  protected int getBtnId(){
	  
	  return this.btnId;
	  
  }
}
