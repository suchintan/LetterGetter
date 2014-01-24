package com.awesome.lettergetter;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LetterGetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_getter);
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
}
