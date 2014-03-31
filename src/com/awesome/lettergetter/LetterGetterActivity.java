package com.awesome.lettergetter;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class LetterGetterActivity extends MenuActivity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_getter);
        //Call incomplete word and get length
        populateButtons(1, gameState.getWord().length());
    }
    
    public void search(View v){
    	EditText editText = (EditText)findViewById(R.id.edit);
    	List<Word> words = new FindWords(this).query(editText.getText().toString());
    	
    	TextView tv = (TextView)findViewById(R.id.text);
    	tv.setText(words.get(0).getWord() + " " + words.get(0).getPoints());
    }
    
    private void populateButtons(int numRows, int numCols) {
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
				//Set the padding
				button.setPadding(0, 0, 0, 0);
				//Gets the letters of the word and prints in button text property
				button.setText(Character.toString(gameState.getWord().charAt(col)));
				tableRow.addView(button);
				button.setMinimumWidth(0);
			}
		}
	}
}
