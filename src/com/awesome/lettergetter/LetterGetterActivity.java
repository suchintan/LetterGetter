package com.awesome.lettergetter;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class LetterGetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_getter);
        
        populateButtons(1,11);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.letter_getter, menu);
        return true;
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
				tableRow.addView(button);
				button.setMinimumWidth(0);
			}
		}
	}
}
