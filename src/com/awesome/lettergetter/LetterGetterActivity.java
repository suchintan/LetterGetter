package com.awesome.lettergetter;

import com.awesome.lettergetter.enums.DIFFICULTY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class LetterGetterActivity extends MenuActivity {
	private Button easyBtn, mediumBtn, hardBtn;
		
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_letter_getter);
          
        if ((GameState.getHasStartedWord() && GameState.getHasCompletedWord() )== false){   
       	 
        	getNextWord();
       	 }
       else if((GameState.getHasStartedWord() == true) && (GameState.getHasCompletedWord() == false)){
       	 
    	   setDifficultyBtnsVisible(false);
    	   populateLetters(1, gameState.getCurrentWord().length());
    	   
    	   
			Intent intent = getIntent();
			final int button_id = intent.getIntExtra("id", 0);
			final String button_ans = intent.getExtras().getString("Ans");
						
			Button mButton = (Button) findViewById(R.id.tableForButtons);
			mButton.setId(button_id);
			mButton.setText(button_ans);
						
       	 
       		}    

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
        
    	GameState.setHasStartedWord(true);
    	
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
				
				
				//startActivity(new Intent(LetterGetterActivity.this, TrayActivity.class));
				
				Intent i = new Intent(LetterGetterActivity.this, TrayActivity.class);
				i.putExtra("id",  button.getId());
				startActivity(i);
				
			}
    		    		
    		
    	};
    	
    	
    };
}
